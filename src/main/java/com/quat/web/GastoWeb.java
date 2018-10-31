package com.quat.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quat.model.Gasto;
import com.quat.model.Proyecto;
import com.quat.service.GastoService;
import com.quat.service.ProyectoService;

@RestController
@RequestMapping("/api/gasto")
public class GastoWeb {

	@Autowired
	GastoService gastoService;

	@Autowired
	ProyectoService proyectoService;
	
	// CRUD
	
	// CREATE
	@PostMapping("/create")
	public Gasto create(@ModelAttribute Gasto gasto, @RequestParam Integer proyecto_id) throws Exception {
		Optional<Proyecto> pOptional = proyectoService.getWithId(proyecto_id);

		if (!pOptional.isPresent()) {
			throw new Exception("No existe el proyecto");
		}

		Proyecto proyecto = pOptional.get();

		gasto.setProyecto(proyecto);
		
		return gastoService.create(gasto);
	}
	
	// READ
	@GetMapping("/all")
	public Iterable<Gasto> getAll() {
		return gastoService.getAll();
	}
	
	@GetMapping("/find")
	public Optional<Gasto> getWithId(@RequestParam Integer id) {
		return gastoService.getWithId(id);
	}
	
	// UPDATE
	@PostMapping("/update")
	public Gasto update(@ModelAttribute Gasto gasto) throws Exception {
		Gasto original = gastoService.getWithId(gasto.getId()).get();

		gasto.setProyecto(original.getProyecto());
		
		return gastoService.update(gasto);
	}
	
	// DELETE
	@PostMapping("/delete")
	public Gasto delete(@ModelAttribute Gasto gasto) throws Exception {
		return gastoService.delete(gasto);
	}
	
}
