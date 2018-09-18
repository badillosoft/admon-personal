package com.quat.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quat.model.RegistroInsumoProyecto;
import com.quat.service.RegistroInsumoProyectoService;

@RestController
@RequestMapping("/api/registroInsumoProyecto")
public class RegistroInsumoProyectoWeb {

	@Autowired
	RegistroInsumoProyectoService registroInsumoProyectoService;
	
	// CRUD
	
	// CREATE
	@PostMapping("/create")
	public RegistroInsumoProyecto create(@ModelAttribute RegistroInsumoProyecto registroInsumoProyecto) throws Exception {
		return registroInsumoProyectoService.create(registroInsumoProyecto);
	}
	
	// READ
	@GetMapping("/all")
	public Iterable<RegistroInsumoProyecto> getAll() {
		return registroInsumoProyectoService.getAll();
	}
	
	@GetMapping("/find")
	public Optional<RegistroInsumoProyecto> getWithId(@RequestParam Integer id) {
		return registroInsumoProyectoService.getWithId(id);
	}
	
	// UPDATE
	@PostMapping("/update")
	public RegistroInsumoProyecto update(@ModelAttribute RegistroInsumoProyecto registroInsumoProyecto) throws Exception {
		return registroInsumoProyectoService.update(registroInsumoProyecto);
	}
	
	// DELETE
	@PostMapping("/delete")
	public RegistroInsumoProyecto delete(@ModelAttribute RegistroInsumoProyecto registroInsumoProyecto) throws Exception {
		return registroInsumoProyectoService.delete(registroInsumoProyecto);
	}
	
}
