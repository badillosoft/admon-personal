package com.quat.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quat.model.Perfil;
import com.quat.repository.PerfilRepository;

@Service
public class PerfilService {

	@Autowired
	PerfilRepository entityRepository;
	
	// CRUD - CREATE / READ / UPDATE / DELETE
	
	// CREATE
	public Perfil create(Perfil entity) throws Exception {
		Optional<Perfil> entityOptional = entityRepository.findById(entity.getId());
		if (entityOptional.isPresent()) {
			throw new Exception("La entidad ya existe en la base de datos");
		}
		return entityRepository.save(entity);
	}
	
	// READ
	public Iterable<Perfil> getAll() {
		return entityRepository.findAll();
	}
	
	public Optional<Perfil> getWithId(Integer id) {
		return entityRepository.findById(id);
	}

	public Optional<Perfil> getWithNombre(String nombre) {
		return entityRepository.findByNombre(nombre);
	}
	
	// UPDATE
	public Perfil update(Perfil entity) throws Exception {
		Optional<Perfil> entityOptional = entityRepository.findById(entity.getId());
		if (!entityOptional.isPresent()) {
			throw new Exception("La entidad no existe en la base de datos");
		}
		return entityRepository.save(entity);
	}
	
	// DELETE
	public Perfil delete(Perfil entity) throws Exception {
		Optional<Perfil> entityOptional = entityRepository.findById(entity.getId());
		if (!entityOptional.isPresent()) {
			throw new Exception("La entidad no existe en la base de datos");
		}
		entityRepository.delete(entity);
		return entity;
	}
	
}
