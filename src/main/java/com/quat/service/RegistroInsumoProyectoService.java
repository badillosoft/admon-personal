package com.quat.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quat.model.RegistroInsumoProyecto;
import com.quat.repository.RegistroInsumoProyectoRepository;

@Service
public class RegistroInsumoProyectoService {

	@Autowired
	RegistroInsumoProyectoRepository registroInsumoProyectoRepository;
	
	// CRUD - CREATE / READ / UPDATE / DELETE
	
	// CREATE
	public RegistroInsumoProyecto create(RegistroInsumoProyecto registroInsumoProyecto) throws Exception {
		Optional<RegistroInsumoProyecto> registroInsumoProyectoOptional = registroInsumoProyectoRepository.findById(registroInsumoProyecto.getId());
		if (registroInsumoProyectoOptional.isPresent()) {
			throw new Exception("La entidad ya existe en la base de datos");
		}
		return registroInsumoProyectoRepository.save(registroInsumoProyecto);
	}
	
	// READ
	public Iterable<RegistroInsumoProyecto> getAll() {
		return registroInsumoProyectoRepository.findAll();
	}
	
	public Optional<RegistroInsumoProyecto> getWithId(Integer id) {
		return registroInsumoProyectoRepository.findById(id);
	}
	
	// UPDATE
	public RegistroInsumoProyecto update(RegistroInsumoProyecto registroInsumoProyecto) throws Exception {
		Optional<RegistroInsumoProyecto> registroInsumoProyectoOptional = registroInsumoProyectoRepository.findById(registroInsumoProyecto.getId());
		if (!registroInsumoProyectoOptional.isPresent()) {
			throw new Exception("La entidad no existe en la base de datos");
		}
		return registroInsumoProyectoRepository.save(registroInsumoProyecto);
	}
	
	// DELETE
	public RegistroInsumoProyecto delete(RegistroInsumoProyecto registroInsumoProyecto) throws Exception {
		Optional<RegistroInsumoProyecto> registroInsumoProyectoOptional = registroInsumoProyectoRepository.findById(registroInsumoProyecto.getId());
		if (!registroInsumoProyectoOptional.isPresent()) {
			throw new Exception("La entidad no existe en la base de datos");
		}
		registroInsumoProyectoRepository.delete(registroInsumoProyecto);
		return registroInsumoProyecto;
	}
	
}
