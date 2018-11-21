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

	public Usuario create(String correo, String contraseña, Integer max_intentos, Integer id_personal) throws Exception {
		Optional<Personal> personalOpt = personalService.getWithId(id_personal);

		if (!personalOpt.isPresent()) {
			throw new Exception("No existe el personal asociado");
		}

		if (credencialService.existsCorreo(correo)) {
			throw new Exception("El correo ya está registrado");
		}

		if (usuarioRepository.existsByPersonalId(id_personal)) {
			throw new Exception("El personal ya tiene asociado un correo");
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
