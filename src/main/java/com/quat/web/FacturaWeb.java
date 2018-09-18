package com.quat.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quat.model.Factura;
import com.quat.service.FacturaService;

@RestController
@RequestMapping("/api/factura")
public class FacturaWeb {

	@Autowired
	FacturaService facturaService;
	
	// CRUD
	
	// CREATE
	@PostMapping("/create")
	public Factura create(@ModelAttribute Factura factura) throws Exception {
		return facturaService.create(factura);
	}
	
	// READ
	@GetMapping("/all")
	public Iterable<Factura> getAll() {
		return facturaService.getAll();
	}
	
	@GetMapping("/find")
	public Optional<Factura> getWithId(@RequestParam Integer id) {
		return facturaService.getWithId(id);
	}
	
	// UPDATE
	@PostMapping("/update")
	public Factura update(@ModelAttribute Factura factura) throws Exception {
		return facturaService.update(factura);
	}
	
	// DELETE
	@PostMapping("/delete")
	public Factura delete(@ModelAttribute Factura factura) throws Exception {
		return facturaService.delete(factura);
	}
	
}
