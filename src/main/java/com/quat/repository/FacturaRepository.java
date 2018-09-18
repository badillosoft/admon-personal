package com.quat.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.quat.model.Factura;

@Transactional
public interface FacturaRepository extends CrudRepository<Factura, Integer> {
	
}
