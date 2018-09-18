package com.quat.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quat.model.AsignacionPersonalPuesto;
import com.quat.repository.AsignacionPersonalPuestoRepository;

@Service
public class AsignacionPersonalPuestoService {

	@Autowired
	AsignacionPersonalPuestoRepository asignacionPersonalPuestoRepository;
	
	// CRUD - CREATE / READ / UPDATE / DELETE
	
	// CREATE
	public AsignacionPersonalPuesto create(AsignacionPersonalPuesto asignacionPersonalPuesto) throws Exception {
		Optional<AsignacionPersonalPuesto> asignacionPersonalPuestoOptional = asignacionPersonalPuestoRepository.findById(asignacionPersonalPuesto.getId());
		if (asignacionPersonalPuestoOptional.isPresent()) {
			throw new Exception("La entidad ya existe en la base de datos");
		}
		return asignacionPersonalPuestoRepository.save(asignacionPersonalPuesto);
	}
	
	// READ
	public Iterable<AsignacionPersonalPuesto> getAll() {
		return asignacionPersonalPuestoRepository.findAll();
	}
	
	public Optional<AsignacionPersonalPuesto> getWithId(Integer id) {
		return asignacionPersonalPuestoRepository.findById(id);
	}
	
	// UPDATE
	public AsignacionPersonalPuesto update(AsignacionPersonalPuesto asignacionPersonalPuesto) throws Exception {
		Optional<AsignacionPersonalPuesto> asignacionPersonalPuestoOptional = asignacionPersonalPuestoRepository.findById(asignacionPersonalPuesto.getId());
		if (!asignacionPersonalPuestoOptional.isPresent()) {
			throw new Exception("La entidad no existe en la base de datos");
		}
		return asignacionPersonalPuestoRepository.save(asignacionPersonalPuesto);
	}
	
	// DELETE
	public AsignacionPersonalPuesto delete(AsignacionPersonalPuesto asignacionPersonalPuesto) throws Exception {
		Optional<AsignacionPersonalPuesto> asignacionPersonalPuestoOptional = asignacionPersonalPuestoRepository.findById(asignacionPersonalPuesto.getId());
		if (!asignacionPersonalPuestoOptional.isPresent()) {
			throw new Exception("La entidad no existe en la base de datos");
		}
		asignacionPersonalPuestoRepository.delete(asignacionPersonalPuesto);
		return asignacionPersonalPuesto;
	}
	
}
