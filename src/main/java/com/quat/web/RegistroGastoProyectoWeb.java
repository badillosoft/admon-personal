package com.quat.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quat.model.RegistroGastoProyecto;
import com.quat.service.RegistroGastoProyectoService;

@RestController
@RequestMapping("/api/registroGastoProyecto")
public class RegistroGastoProyectoWeb {

	@Autowired
	RegistroGastoProyectoService registroGastoProyectoService;
	
	// CRUD
	
	// CREATE
	@PostMapping("/create")
	public RegistroGastoProyecto create(@ModelAttribute RegistroGastoProyecto registroGastoProyecto) throws Exception {
		return registroGastoProyectoService.create(registroGastoProyecto);
	}
	
	// READ
	@GetMapping("/all")
	public Iterable<RegistroGastoProyecto> getAll() {
		return registroGastoProyectoService.getAll();
	}
	
	@GetMapping("/find")
	public Optional<RegistroGastoProyecto> getWithId(@RequestParam Integer id) {
		return registroGastoProyectoService.getWithId(id);
	}
	
	// UPDATE
	@PostMapping("/update")
	public RegistroGastoProyecto update(@ModelAttribute RegistroGastoProyecto registroGastoProyecto) throws Exception {
		return registroGastoProyectoService.update(registroGastoProyecto);
	}
	
	// DELETE
	@PostMapping("/delete")
	public RegistroGastoProyecto delete(@ModelAttribute RegistroGastoProyecto registroGastoProyecto) throws Exception {
		return registroGastoProyectoService.delete(registroGastoProyecto);
	}
	
}
