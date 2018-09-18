package com.quat.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quat.model.AsignacionPersonalPuesto;
import com.quat.service.AsignacionPersonalPuestoService;

@RestController
@RequestMapping("/api/asignacionPersonalPuesto")
public class AsignacionPersonalPuestoWeb {

	@Autowired
	AsignacionPersonalPuestoService asignacionPersonalPuestoService;
	
	// CRUD
	
	// CREATE
	@PostMapping("/create")
	public AsignacionPersonalPuesto create(@ModelAttribute AsignacionPersonalPuesto asignacionPersonalPuesto) throws Exception {
		return asignacionPersonalPuestoService.create(asignacionPersonalPuesto);
	}
	
	// READ
	@GetMapping("/all")
	public Iterable<AsignacionPersonalPuesto> getAll() {
		return asignacionPersonalPuestoService.getAll();
	}
	
	@GetMapping("/find")
	public Optional<AsignacionPersonalPuesto> getWithId(@RequestParam Integer id) {
		return asignacionPersonalPuestoService.getWithId(id);
	}
	
	// UPDATE
	@PostMapping("/update")
	public AsignacionPersonalPuesto update(@ModelAttribute AsignacionPersonalPuesto asignacionPersonalPuesto) throws Exception {
		return asignacionPersonalPuestoService.update(asignacionPersonalPuesto);
	}
	
	// DELETE
	@PostMapping("/delete")
	public AsignacionPersonalPuesto delete(@ModelAttribute AsignacionPersonalPuesto asignacionPersonalPuesto) throws Exception {
		return asignacionPersonalPuestoService.delete(asignacionPersonalPuesto);
	}
	
}
