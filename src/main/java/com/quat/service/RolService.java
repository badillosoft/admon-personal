package com.quat.service;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quat.model.Rol;
import com.quat.model.Usuario;
import com.quat.repository.RolRepository;
import com.quat.repository.UsuarioRepository;

@Service
public class RolService {

	@Autowired
	RolRepository entityRepository;

	@Autowired
	UsuarioRepository usuarioRepository;
	
	// CRUD - CREATE / READ / UPDATE / DELETE
	
	// CREATE
	public Rol create(Rol entity) throws Exception {
		Optional<Rol> entityOptional = entityRepository.findById(entity.getId());
		if (entityOptional.isPresent()) {
			throw new Exception("La entidad ya existe en la base de datos");
		}
		return entityRepository.save(entity);
	}
	
	// READ
	public Iterable<Rol> getAll() {
		return entityRepository.findAll();
	}

	public Set<Rol> getRoles(Integer id_usuario) {
		Optional<Usuario> usuarioOpt = usuarioRepository.findById(id_usuario);
		if (!usuarioOpt.isPresent()) {
			return null;
		}
		Usuario usuario = usuarioOpt.get();

		return usuario.getPerfil().getRoles();
	}
	
	public Optional<Rol> getWithId(Integer id) {
		return entityRepository.findById(id);
	}
	
	// UPDATE
	public Rol update(Rol entity) throws Exception {
		Optional<Rol> entityOptional = entityRepository.findById(entity.getId());
		if (!entityOptional.isPresent()) {
			throw new Exception("La entidad no existe en la base de datos");
		}
		return entityRepository.save(entity);
	}
	
	// DELETE
	public Rol delete(Rol entity) throws Exception {
		Optional<Rol> entityOptional = entityRepository.findById(entity.getId());
		if (!entityOptional.isPresent()) {
			throw new Exception("La entidad no existe en la base de datos");
		}
		entityRepository.delete(entity);
		return entity;
	}
	
}
