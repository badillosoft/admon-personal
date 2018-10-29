package com.quat.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quat.model.Perfil;
import com.quat.service.PerfilService;

@RestController
@RequestMapping("/api/perfil")
public class PerfilWeb {

	@Autowired
	PerfilService entityService;
	
	// CRUD
	
	// CREATE
	@PostMapping("/create")
	public Perfil create(@ModelAttribute Perfil entity) throws Exception {
		return entityService.create(entity);
	}
	
	// READ
	@GetMapping("/all")
	public Iterable<Perfil> getAll() {
		return entityService.getAll();
	}
	
	@GetMapping("/find")
	public Optional<Perfil> getWithId(@RequestParam Integer id) {
		return entityService.getWithId(id);
	}
	
	// UPDATE
	@PostMapping("/update")
	public Perfil update(@ModelAttribute Perfil entity) throws Exception {
		return entityService.update(entity);
	}
	
	// DELETE
	@PostMapping("/delete")
	public Perfil delete(@ModelAttribute Perfil entity) throws Exception {
		return entityService.delete(entity);
	}
	
}
