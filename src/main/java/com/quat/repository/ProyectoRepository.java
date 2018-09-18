package com.quat.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.quat.model.Proyecto;

@Transactional
public interface ProyectoRepository extends CrudRepository<Proyecto, Integer> {
	
}
