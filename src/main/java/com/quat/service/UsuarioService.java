package com.quat.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quat.model.Usuario;
import com.quat.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository entityRepository;
	
	// CRUD - CREATE / READ / UPDATE / DELETE
	
	// CREATE
	public Usuario create(Usuario entity) throws Exception {
		Optional<Usuario> entityOptional = entityRepository.findById(entity.getId());
		if (entityOptional.isPresent()) {
			throw new Exception("La entidad ya existe en la base de datos");
		}
		return entityRepository.save(entity);
	}
	
	// READ
	public Iterable<Usuario> getAll() {
		return entityRepository.findAll();
	}
	
	public Optional<Usuario> getWithId(Integer id) {
		return entityRepository.findById(id);
	}
	
	// UPDATE
	public Usuario update(Usuario entity) throws Exception {
		Optional<Usuario> entityOptional = entityRepository.findById(entity.getId());
		if (!entityOptional.isPresent()) {
			throw new Exception("La entidad no existe en la base de datos");
		}
		return entityRepository.save(entity);
	}
	
	// DELETE
	public Usuario delete(Usuario entity) throws Exception {
		Optional<Usuario> entityOptional = entityRepository.findById(entity.getId());
		if (!entityOptional.isPresent()) {
			throw new Exception("La entidad no existe en la base de datos");
		}
		entityRepository.delete(entity);
		return entity;
	}
	
}
