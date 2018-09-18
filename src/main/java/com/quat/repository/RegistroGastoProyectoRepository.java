package com.quat.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.quat.model.RegistroGastoProyecto;

@Transactional
public interface RegistroGastoProyectoRepository extends CrudRepository<RegistroGastoProyecto, Integer> {
	
}
