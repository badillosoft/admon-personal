package com.quat.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quat.model.AsignacionPersonalProyecto;
import com.quat.service.AsignacionPersonalProyectoService;

@RestController
@RequestMapping("/api/asignacionPersonalProyecto")
public class AsignacionPersonalProyectoWeb {

	@Autowired
	AsignacionPersonalProyectoService asignacionPersonalProyectoService;
	
	// CRUD
	
	// CREATE
	@PostMapping("/create")
	public AsignacionPersonalProyecto create(@ModelAttribute AsignacionPersonalProyecto asignacionPersonalProyecto) throws Exception {
		return asignacionPersonalProyectoService.create(asignacionPersonalProyecto);
	}
	
	// READ
	@GetMapping("/all")
	public Iterable<AsignacionPersonalProyecto> getAll() {
		return asignacionPersonalProyectoService.getAll();
	}
	
	@GetMapping("/find")
	public Optional<AsignacionPersonalProyecto> getWithId(@RequestParam Integer id) {
		return asignacionPersonalProyectoService.getWithId(id);
	}
	
	// UPDATE
	@PostMapping("/update")
	public AsignacionPersonalProyecto update(@ModelAttribute AsignacionPersonalProyecto asignacionPersonalProyecto) throws Exception {
		return asignacionPersonalProyectoService.update(asignacionPersonalProyecto);
	}
	
	// DELETE
	@PostMapping("/delete")
	public AsignacionPersonalProyecto delete(@ModelAttribute AsignacionPersonalProyecto asignacionPersonalProyecto) throws Exception {
		return asignacionPersonalProyectoService.delete(asignacionPersonalProyecto);
	}
	
}
