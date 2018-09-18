package com.quat.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quat.model.Gasto;
import com.quat.repository.GastoRepository;

@Service
public class GastoService {

	@Autowired
	GastoRepository gastoRepository;
	
	// CRUD - CREATE / READ / UPDATE / DELETE
	
	// CREATE
	public Gasto create(Gasto gasto) throws Exception {
		Optional<Gasto> gastoOptional = gastoRepository.findById(gasto.getId());
		if (gastoOptional.isPresent()) {
			throw new Exception("La entidad ya existe en la base de datos");
		}
		return gastoRepository.save(gasto);
	}
	
	// READ
	public Iterable<Gasto> getAll() {
		return gastoRepository.findAll();
	}
	
	public Optional<Gasto> getWithId(Integer id) {
		return gastoRepository.findById(id);
	}
	
	// UPDATE
	public Gasto update(Gasto gasto) throws Exception {
		Optional<Gasto> gastoOptional = gastoRepository.findById(gasto.getId());
		if (!gastoOptional.isPresent()) {
			throw new Exception("La entidad no existe en la base de datos");
		}
		return gastoRepository.save(gasto);
	}
	
	// DELETE
	public Gasto delete(Gasto gasto) throws Exception {
		Optional<Gasto> gastoOptional = gastoRepository.findById(gasto.getId());
		if (!gastoOptional.isPresent()) {
			throw new Exception("La entidad no existe en la base de datos");
		}
		gastoRepository.delete(gasto);
		return gasto;
	}
	
}
