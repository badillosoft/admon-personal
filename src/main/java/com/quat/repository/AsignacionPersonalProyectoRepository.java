package com.quat.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.quat.model.AsignacionPersonalProyecto;

@Transactional
public interface AsignacionPersonalProyectoRepository extends CrudRepository<AsignacionPersonalProyecto, Integer> {
	
}
