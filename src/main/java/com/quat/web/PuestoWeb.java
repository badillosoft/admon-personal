package com.quat.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quat.model.Puesto;
import com.quat.service.PuestoService;

@RestController
@RequestMapping("/api/puesto")
public class PuestoWeb {

	@Autowired
	PuestoService puestoService;
	
	// CRUD
	
	// CREATE
	@PostMapping("/create")
	public Puesto create(@ModelAttribute Puesto puesto) throws Exception {
		return puestoService.create(puesto);
	}
	
	// READ
	@GetMapping("/all")
	public Iterable<Puesto> getAll() {
		return puestoService.getAll();
	}
	
	@GetMapping("/find")
	public Optional<Puesto> getWithId(@RequestParam Integer id) {
		return puestoService.getWithId(id);
	}
	
	// UPDATE
	@PostMapping("/update")
	public Puesto update(@ModelAttribute Puesto puesto) throws Exception {
		return puestoService.update(puesto);
	}
	
	// DELETE
	@PostMapping("/delete")
	public Puesto delete(@ModelAttribute Puesto puesto) throws Exception {
		return puestoService.delete(puesto);
	}
	
}
