package com.quat.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quat.model.Credencial;
import com.quat.model.Personal;
import com.quat.model.Usuario;
import com.quat.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;

	@Autowired
	PersonalService personalService;

	@Autowired
	CredencialService credencialService;
	
	// CRUD - CREATE / READ / UPDATE / DELETE
	
	// CREATE
	public Usuario create(Usuario entity) throws Exception {
		Optional<Usuario> entityOptional = usuarioRepository.findById(entity.getId());
		if (entityOptional.isPresent()) {
			throw new Exception("La entidad ya existe en la base de datos");
		}
		return usuarioRepository.save(entity);
	}

	public Usuario create(String correo, String contraseña, Integer max_intentos, Integer personal_id) throws Exception {
		Optional<Personal> personalOpt = personalService.getWithId(personal_id);

		if (!personalOpt.isPresent()) {
			throw new Exception("No existe el personal asociado");
		}

		if (credencialService.existsCorreo(correo)) {
			throw new Exception("El correo ya está registrado");
		}

		if (usuarioRepository.existsByPersonalId(personal_id)) {
			throw new Exception("El personal ya tiene asociado un usuario");
		}
		
		Usuario usuario = new Usuario();

		usuario.setId(0);

		usuario.setPersonal(personalOpt.get());
		
		Credencial credencial = new Credencial();

		credencial.setId(0);
		credencial.setCorreo(correo);
		credencial.setContraseña(contraseña);
		credencial.setMax_intentos(max_intentos);
		credencial.setIntentos(0);
		
		credencial = credencialService.create(credencial);

		usuario.setCredencial(credencial);

		usuario.setActivo(true);

		return this.usuarioRepository.save(usuario);
	}

	public Usuario update(Integer id, String correo, String contraseña,
		Integer max_intentos, Integer intentos,
		Integer personal_id) throws Exception {
		Optional<Usuario> uOptional = usuarioRepository.findById(id);

		if (!uOptional.isPresent()) {
			throw new Exception("El usuario no existe");
		}

		Optional<Personal> personalOpt = personalService.getWithId(personal_id);

		if (!personalOpt.isPresent()) {
			throw new Exception("No existe el personal asociado");
		}

		Usuario usuario = uOptional.get();
		
		Credencial credencial = usuario.getCredencial();

		if (credencial == null || !credencial.getCorreo().equals(correo)) {
			if (credencialService.existsCorreo(correo)) {
				throw new Exception("El correo ya está registrado");
			}
			if (credencial == null) {
				Credencial nuevaCredencial = new Credencial();

				nuevaCredencial.setId(0);
				nuevaCredencial.setCorreo(correo);
				nuevaCredencial.setContraseña(contraseña);
				nuevaCredencial.setMax_intentos(max_intentos);
				nuevaCredencial.setIntentos(0);
				
				credencial = credencialService.create(nuevaCredencial);
			}
		}

		credencial.setCorreo(correo);
		credencial.setContraseña(contraseña);
		credencial.setMax_intentos(max_intentos);
		credencial.setIntentos(intentos);
		
		usuario.setCredencial(credencial);

		Personal personal = usuario.getPersonal();

		if (personal == null || personal.getId() != personal_id) {
			if (usuarioRepository.existsByPersonalId(personal_id)) {
				throw new Exception("El personal ya tiene asociado un usuario");
			}
			personal = personalOpt.get();
		}

		usuario.setPersonal(personal);
		
		usuario.setActivo(true);

		return this.usuarioRepository.save(usuario);
	}
	
	// READ
	public Iterable<Usuario> getAll() {
		return usuarioRepository.findAll();
	}
	
	public Optional<Usuario> getWithId(Integer id) {
		return usuarioRepository.findById(id);
	}
	
	// UPDATE
	public Usuario update(Usuario entity) throws Exception {
		Optional<Usuario> entityOptional = usuarioRepository.findById(entity.getId());
		if (!entityOptional.isPresent()) {
			throw new Exception("La entidad no existe en la base de datos");
		}
		return usuarioRepository.save(entity);
	}
	
	// DELETE
	public Usuario delete(Usuario entity) throws Exception {
		Optional<Usuario> entityOptional = usuarioRepository.findById(entity.getId());
		if (!entityOptional.isPresent()) {
			throw new Exception("La entidad no existe en la base de datos");
		}
		usuarioRepository.delete(entity);
		return entity;
	}
	
}
