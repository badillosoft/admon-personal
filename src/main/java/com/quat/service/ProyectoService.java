package com.quat.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quat.model.Proyecto;
import com.quat.repository.ProyectoRepository;

@Service
public class ProyectoService {

	@Autowired
	ProyectoRepository proyectoRepository;
	
	// CRUD - CREATE / READ / UPDATE / DELETE
	
	// CREATE
	public Proyecto create(Proyecto proyecto) throws Exception {
		Optional<Proyecto> proyectoOptional = proyectoRepository.findById(proyecto.getId());
		if (proyectoOptional.isPresent()) {
			throw new Exception("La entidad ya existe en la base de datos");
		}
		proyecto.setActivo(true);
		return proyectoRepository.save(proyecto);
	}
	
	// READ
	public Iterable<Proyecto> getAll() {
		return proyectoRepository.findAll();
	}
	
	public Optional<Proyecto> getWithId(Integer id) {
		return proyectoRepository.findById(id);
	}
	
	// UPDATE
	public Proyecto update(Proyecto proyecto) throws Exception {
		Optional<Proyecto> proyectoOptional = proyectoRepository.findById(proyecto.getId());
		if (!proyectoOptional.isPresent()) {
			throw new Exception("La entidad no existe en la base de datos");
		}
		proyecto.setActivo(true);
		return proyectoRepository.save(proyecto);
	}
	
	// DELETE
	public Proyecto delete(Proyecto proyecto) throws Exception {
		Optional<Proyecto> proyectoOptional = proyectoRepository.findById(proyecto.getId());
		if (!proyectoOptional.isPresent()) {
			throw new Exception("La entidad no existe en la base de datos");
		}
		proyecto.setActivo(false);
		proyectoRepository.save(proyecto);
		return proyecto;
	}
	
}
