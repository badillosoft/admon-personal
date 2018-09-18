package com.quat.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.quat.model.AsignacionPersonalPuesto;

@Transactional
public interface AsignacionPersonalPuestoRepository extends CrudRepository<AsignacionPersonalPuesto, Integer> {
	
}
