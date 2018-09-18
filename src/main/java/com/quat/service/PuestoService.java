package com.quat.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quat.model.Puesto;
import com.quat.repository.PuestoRepository;

@Service
public class PuestoService {

	@Autowired
	PuestoRepository puestoRepository;
	
	// CRUD - CREATE / READ / UPDATE / DELETE
	
	// CREATE
	public Puesto create(Puesto puesto) throws Exception {
		Optional<Puesto> puestoOptional = puestoRepository.findById(puesto.getId());
		if (puestoOptional.isPresent()) {
			throw new Exception("La entidad ya existe en la base de datos");
		}
		return puestoRepository.save(puesto);
	}
	
	// READ
	public Iterable<Puesto> getAll() {
		return puestoRepository.findAll();
	}
	
	public Optional<Puesto> getWithId(Integer id) {
		return puestoRepository.findById(id);
	}
	
	// UPDATE
	public Puesto update(Puesto puesto) throws Exception {
		Optional<Puesto> puestoOptional = puestoRepository.findById(puesto.getId());
		if (!puestoOptional.isPresent()) {
			throw new Exception("La entidad no existe en la base de datos");
		}
		return puestoRepository.save(puesto);
	}
	
	// DELETE
	public Puesto delete(Puesto puesto) throws Exception {
		Optional<Puesto> puestoOptional = puestoRepository.findById(puesto.getId());
		if (!puestoOptional.isPresent()) {
			throw new Exception("La entidad no existe en la base de datos");
		}
		puestoRepository.delete(puesto);
		return puesto;
	}
	
}
