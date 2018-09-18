package com.quat.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quat.model.Personal;
import com.quat.repository.PersonalRepository;

@Service
public class PersonalService {

	@Autowired
	PersonalRepository personalRepository;
	
	// CRUD - CREATE / READ / UPDATE / DELETE
	
	// CREATE
	public Personal create(Personal personal) throws Exception {
		Optional<Personal> personalOptional = personalRepository.findById(personal.getId());
		if (personalOptional.isPresent()) {
			throw new Exception("La entidad ya existe en la base de datos");
		}
		return personalRepository.save(personal);
	}
	
	// READ
	public Iterable<Personal> getAll() {
		return personalRepository.findAll();
	}
	
	public Optional<Personal> getWithId(Integer id) {
		return personalRepository.findById(id);
	}
	
	// UPDATE
	public Personal update(Personal personal) throws Exception {
		Optional<Personal> personalOptional = personalRepository.findById(personal.getId());
		if (!personalOptional.isPresent()) {
			throw new Exception("La entidad no existe en la base de datos");
		}
		return personalRepository.save(personal);
	}
	
	// DELETE
	public Personal delete(Personal personal) throws Exception {
		Optional<Personal> personalOptional = personalRepository.findById(personal.getId());
		if (!personalOptional.isPresent()) {
			throw new Exception("La entidad no existe en la base de datos");
		}
		personalRepository.delete(personal);
		return personal;
	}
	
}
