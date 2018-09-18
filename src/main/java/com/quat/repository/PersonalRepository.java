package com.quat.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.quat.model.Personal;

@Transactional
public interface PersonalRepository extends CrudRepository<Personal, Integer> {
	
}
