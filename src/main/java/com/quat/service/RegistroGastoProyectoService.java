package com.quat.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quat.model.RegistroGastoProyecto;
import com.quat.repository.RegistroGastoProyectoRepository;

@Service
public class RegistroGastoProyectoService {

	@Autowired
	RegistroGastoProyectoRepository registroGastoProyectoRepository;
	
	// CRUD - CREATE / READ / UPDATE / DELETE
	
	// CREATE
	public RegistroGastoProyecto create(RegistroGastoProyecto registroGastoProyecto) throws Exception {
		Optional<RegistroGastoProyecto> registroGastoProyectoOptional = registroGastoProyectoRepository.findById(registroGastoProyecto.getId());
		if (registroGastoProyectoOptional.isPresent()) {
			throw new Exception("La entidad ya existe en la base de datos");
		}
		return registroGastoProyectoRepository.save(registroGastoProyecto);
	}
	
	// READ
	public Iterable<RegistroGastoProyecto> getAll() {
		return registroGastoProyectoRepository.findAll();
	}
	
	public Optional<RegistroGastoProyecto> getWithId(Integer id) {
		return registroGastoProyectoRepository.findById(id);
	}
	
	// UPDATE
	public RegistroGastoProyecto update(RegistroGastoProyecto registroGastoProyecto) throws Exception {
		Optional<RegistroGastoProyecto> registroGastoProyectoOptional = registroGastoProyectoRepository.findById(registroGastoProyecto.getId());
		if (!registroGastoProyectoOptional.isPresent()) {
			throw new Exception("La entidad no existe en la base de datos");
		}
		return registroGastoProyectoRepository.save(registroGastoProyecto);
	}
	
	// DELETE
	public RegistroGastoProyecto delete(RegistroGastoProyecto registroGastoProyecto) throws Exception {
		Optional<RegistroGastoProyecto> registroGastoProyectoOptional = registroGastoProyectoRepository.findById(registroGastoProyecto.getId());
		if (!registroGastoProyectoOptional.isPresent()) {
			throw new Exception("La entidad no existe en la base de datos");
		}
		registroGastoProyectoRepository.delete(registroGastoProyecto);
		return registroGastoProyecto;
	}
	
}
