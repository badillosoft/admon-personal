package com.quat.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quat.model.AsignacionPersonalProyecto;
import com.quat.repository.AsignacionPersonalProyectoRepository;

@Service
public class AsignacionPersonalProyectoService {

	@Autowired
	AsignacionPersonalProyectoRepository asignacionPersonalProyectoRepository;
	
	// CRUD - CREATE / READ / UPDATE / DELETE
	
	// CREATE
	public AsignacionPersonalProyecto create(AsignacionPersonalProyecto asignacionPersonalProyecto) throws Exception {
		Optional<AsignacionPersonalProyecto> asignacionPersonalProyectoOptional = asignacionPersonalProyectoRepository.findById(asignacionPersonalProyecto.getId());
		if (asignacionPersonalProyectoOptional.isPresent()) {
			throw new Exception("La entidad ya existe en la base de datos");
		}
		return asignacionPersonalProyectoRepository.save(asignacionPersonalProyecto);
	}
	
	// READ
	public Iterable<AsignacionPersonalProyecto> getAll() {
		return asignacionPersonalProyectoRepository.findAll();
	}
	
	public Optional<AsignacionPersonalProyecto> getWithId(Integer id) {
		return asignacionPersonalProyectoRepository.findById(id);
	}
	
	// UPDATE
	public AsignacionPersonalProyecto update(AsignacionPersonalProyecto asignacionPersonalProyecto) throws Exception {
		Optional<AsignacionPersonalProyecto> asignacionPersonalProyectoOptional = asignacionPersonalProyectoRepository.findById(asignacionPersonalProyecto.getId());
		if (!asignacionPersonalProyectoOptional.isPresent()) {
			throw new Exception("La entidad no existe en la base de datos");
		}
		return asignacionPersonalProyectoRepository.save(asignacionPersonalProyecto);
	}
	
	// DELETE
	public AsignacionPersonalProyecto delete(AsignacionPersonalProyecto asignacionPersonalProyecto) throws Exception {
		Optional<AsignacionPersonalProyecto> asignacionPersonalProyectoOptional = asignacionPersonalProyectoRepository.findById(asignacionPersonalProyecto.getId());
		if (!asignacionPersonalProyectoOptional.isPresent()) {
			throw new Exception("La entidad no existe en la base de datos");
		}
		asignacionPersonalProyectoRepository.delete(asignacionPersonalProyecto);
		return asignacionPersonalProyecto;
	}
	
}
