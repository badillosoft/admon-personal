package com.quat.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quat.model.Credencial;
import com.quat.repository.CredencialRepository;

@Service
public class CredencialService {

	@Autowired
	CredencialRepository entityRepository;
	
	// CRUD - CREATE / READ / UPDATE / DELETE
	
	// CREATE
	public Credencial create(Credencial entity) throws Exception {
		Optional<Credencial> entityOptional = entityRepository.findById(entity.getId());
		if (entityOptional.isPresent()) {
			throw new Exception("La entidad ya existe en la base de datos");
		}
		return entityRepository.save(entity);
	}
	
	// READ
	public Iterable<Credencial> getAll() {
		return entityRepository.findAll();
	}
	
	public Optional<Credencial> getWithId(Integer id) {
		return entityRepository.findById(id);
	}
	
	// UPDATE
	public Credencial update(Credencial entity) throws Exception {
		Optional<Credencial> entityOptional = entityRepository.findById(entity.getId());
		if (!entityOptional.isPresent()) {
			throw new Exception("La entidad no existe en la base de datos");
		}
		return entityRepository.save(entity);
	}
	
	// DELETE
	public Credencial delete(Credencial entity) throws Exception {
		Optional<Credencial> entityOptional = entityRepository.findById(entity.getId());
		if (!entityOptional.isPresent()) {
			throw new Exception("La entidad no existe en la base de datos");
		}
		entityRepository.delete(entity);
		return entity;
	}

	public Integer login(String correo, String contraseña) {
		return entityRepository.login(correo, contraseña);
	}

	public boolean existsCorreo(String correo) {
		return entityRepository.existsByCorreo(correo);
	}
	
}
