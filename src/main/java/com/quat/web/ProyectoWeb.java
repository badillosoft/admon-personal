package com.quat.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quat.model.Proyecto;
import com.quat.service.ProyectoService;

@RestController
@RequestMapping("/api/proyecto")
public class ProyectoWeb {

	@Autowired
	ProyectoService proyectoService;
	
	// CRUD
	
	// CREATE
	@PostMapping("/create")
	public Proyecto create(@ModelAttribute Proyecto proyecto) throws Exception {
		return proyectoService.create(proyecto);
	}
	
	// READ
	@GetMapping("/all")
	public Iterable<Proyecto> getAll() {
		return proyectoService.getAll();
	}
	
	@GetMapping("/find")
	public Optional<Proyecto> getWithId(@RequestParam Integer id) {
		return proyectoService.getWithId(id);
	}
	
	// UPDATE
	@PostMapping("/update")
	public Proyecto update(@ModelAttribute Proyecto proyecto) throws Exception {
		return proyectoService.update(proyecto);
	}
	
	// DELETE
	@PostMapping("/delete")
	public Proyecto delete(@ModelAttribute Proyecto proyecto) throws Exception {
		return proyectoService.delete(proyecto);
	}
	
}
