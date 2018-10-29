package com.quat.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.quat.model.Perfil;

@Transactional
public interface PerfilRepository extends CrudRepository<Perfil, Integer> {
	
}
