package com.quat.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quat.model.Usuario;
import com.quat.service.UsuarioService;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioWeb {

	@Autowired
	UsuarioService entityService;
	
	// CRUD
	
	// CREATE
	@PostMapping("/create")
	public Usuario create(@ModelAttribute Usuario entity) throws Exception {
		return entityService.create(entity);
	}
	
	// READ
	@GetMapping("/all")
	public Iterable<Usuario> getAll() {
		return entityService.getAll();
	}
	
	@GetMapping("/find")
	public Optional<Usuario> getWithId(@RequestParam Integer id) {
		return entityService.getWithId(id);
	}
	
	// UPDATE
	@PostMapping("/update")
	public Usuario update(@ModelAttribute Usuario entity) throws Exception {
		return entityService.update(entity);
	}
	
	// DELETE
	@PostMapping("/delete")
	public Usuario delete(@ModelAttribute Usuario entity) throws Exception {
		return entityService.delete(entity);
	}
	
}
