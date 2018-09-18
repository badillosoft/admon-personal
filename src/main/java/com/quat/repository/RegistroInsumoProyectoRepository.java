package com.quat.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.quat.model.RegistroInsumoProyecto;

@Transactional
public interface RegistroInsumoProyectoRepository extends CrudRepository<RegistroInsumoProyecto, Integer> {
	
}
