package com.quat.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quat.model.Factura;
import com.quat.repository.FacturaRepository;

@Service
public class FacturaService {

	@Autowired
	FacturaRepository facturaRepository;
	
	// CRUD - CREATE / READ / UPDATE / DELETE
	
	// CREATE
	public Factura create(Factura factura) throws Exception {
		Optional<Factura> facturaOptional = facturaRepository.findById(factura.getId());
		if (facturaOptional.isPresent()) {
			throw new Exception("La entidad ya existe en la base de datos");
		}
		return facturaRepository.save(factura);
	}
	
	// READ
	public Iterable<Factura> getAll() {
		return facturaRepository.findAll();
	}
	
	public Optional<Factura> getWithId(Integer id) {
		return facturaRepository.findById(id);
	}
	
	// UPDATE
	public Factura update(Factura factura) throws Exception {
		Optional<Factura> facturaOptional = facturaRepository.findById(factura.getId());
		if (!facturaOptional.isPresent()) {
			throw new Exception("La entidad no existe en la base de datos");
		}
		return facturaRepository.save(factura);
	}
	
	// DELETE
	public Factura delete(Factura factura) throws Exception {
		Optional<Factura> facturaOptional = facturaRepository.findById(factura.getId());
		if (!facturaOptional.isPresent()) {
			throw new Exception("La entidad no existe en la base de datos");
		}
		facturaRepository.delete(factura);
		return factura;
	}
	
}
