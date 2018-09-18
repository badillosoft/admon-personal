package com.quat.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.quat.model.Gasto;

@Transactional
public interface GastoRepository extends CrudRepository<Gasto, Integer> {
	
}
