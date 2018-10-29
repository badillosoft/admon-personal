package com.quat.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quat.model.Credencial;
import com.quat.service.CredencialService;

@RestController
@RequestMapping("/api/credencial")
public class CredencialWeb {

	@Autowired
	CredencialService entityService;
	
	// CRUD
	
	// CREATE
	@PostMapping("/create")
	public Credencial create(@ModelAttribute Credencial entity) throws Exception {
		return entityService.create(entity);
	}

	@PostMapping("/login")
	public Integer login(@RequestParam String correo, @RequestParam String contraseña) {
		return entityService.login(correo, contraseña);
	}
	
	// READ
	@GetMapping("/all")
	public Iterable<Credencial> getAll() {
		return entityService.getAll();
	}
	
	@GetMapping("/find")
	public Optional<Credencial> getWithId(@RequestParam Integer id) {
		return entityService.getWithId(id);
	}
	
	// UPDATE
	@PostMapping("/update")
	public Credencial update(@ModelAttribute Credencial entity) throws Exception {
		return entityService.update(entity);
	}
	
	// DELETE
	@PostMapping("/delete")
	public Credencial delete(@ModelAttribute Credencial entity) throws Exception {
		return entityService.delete(entity);
	}
	
}
