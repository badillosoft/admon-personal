package com.quat.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quat.model.Rol;
import com.quat.service.RolService;

@RestController
@RequestMapping("/api/rol")
public class RolWeb {

	@Autowired
	RolService entityService;
	
	// CRUD
	
	// CREATE
	@PostMapping("/create")
	public Rol create(@ModelAttribute Rol entity) throws Exception {
		return entityService.create(entity);
	}
	
	// READ
	@GetMapping("/all")
	public Iterable<Rol> getAll() {
		return entityService.getAll();
	}

	@GetMapping("/usuario")
	public Iterable<Rol> getARoles(@RequestParam Integer id_usuario) {
		return entityService.getRoles(id_usuario);
	}
	
	@GetMapping("/find")
	public Optional<Rol> getWithId(@RequestParam Integer id) {
		return entityService.getWithId(id);
	}
	
	// UPDATE
	@PostMapping("/update")
	public Rol update(@ModelAttribute Rol entity) throws Exception {
		return entityService.update(entity);
	}
	
	// DELETE
	@PostMapping("/delete")
	public Rol delete(@ModelAttribute Rol entity) throws Exception {
		return entityService.delete(entity);
	}
	
}
