package com.quat.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quat.model.Credencial;
import com.quat.model.Usuario;
import com.quat.repository.CredencialRepository;

@Service
public class CredencialService {

	@Autowired
	CredencialRepository credencialRepository;

	@Autowired
	UsuarioService usuarioService;
	
	// CRUD - CREATE / READ / UPDATE / DELETE
	
	// CREATE
	public Credencial create(Credencial entity) throws Exception {
		Optional<Credencial> entityOptional = credencialRepository.findById(entity.getId());
		if (entityOptional.isPresent()) {
			throw new Exception("La entidad ya existe en la base de datos");
		}
		return credencialRepository.save(entity);
	}
	
	// READ
	public Iterable<Credencial> getAll() {
		return credencialRepository.findAll();
	}
	
	public Optional<Credencial> getWithId(Integer id) {
		return credencialRepository.findById(id);
	}
	
	// UPDATE
	public Credencial update(Credencial entity) throws Exception {
		Optional<Credencial> entityOptional = credencialRepository.findById(entity.getId());
		if (!entityOptional.isPresent()) {
			throw new Exception("La entidad no existe en la base de datos");
		}
		return credencialRepository.save(entity);
	}
	
	// DELETE
	public Credencial delete(Credencial entity) throws Exception {
		Optional<Credencial> entityOptional = credencialRepository.findById(entity.getId());
		if (!entityOptional.isPresent()) {
			throw new Exception("La entidad no existe en la base de datos");
		}
		credencialRepository.delete(entity);
		return entity;
	}

	public Integer login(String correo, String contraseña) throws Exception {
		Integer usuario_id = credencialRepository.login(correo);

		if (usuario_id == null) {
			throw new Exception("El correo no está registrado para ningún usuario");
		}

		Optional<Usuario> usuarioOpt = usuarioService.getWithId(usuario_id);

		if (!usuarioOpt.isPresent()) {
			throw new Exception("La credencial no corresponde a un usuario válido");
		}

		Usuario usuario = usuarioOpt.get();

		Credencial credencial = usuario.getCredencial();

		if (credencial == null) {
			throw new Exception("El usuario no tiene credenciales");
		}

		Integer intentos = credencial.getIntentos();
		Integer max_intentos = credencial.getMax_intentos();

		if (intentos == null) {
			intentos = 0;
		}

		if (max_intentos == null) {
			max_intentos = 0;
		}

		if (intentos >= max_intentos) {
			throw new Exception("El usuario ha superado el máximo de intentos permitidos");
		}

		if (!credencial.getContraseña().equals(contraseña)) {
			intentos++;
			credencial.setIntentos(intentos);
			usuario.setCredencial(credencial);
			usuarioService.update(usuario);
			throw new Exception(String.format("Credenciales no válidas (intentos %s de %s)", intentos, max_intentos));
		}

		intentos = 0;

		credencial.setIntentos(intentos);
		usuario.setCredencial(credencial);
		usuarioService.update(usuario);

		return usuario_id;
	}

	public boolean existsCorreo(String correo) {
		return credencialRepository.existsByCorreo(correo);
	}
	
}
