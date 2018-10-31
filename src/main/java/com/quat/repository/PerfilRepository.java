package com.quat.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.quat.model.Perfil;

@Transactional
public interface PerfilRepository extends CrudRepository<Perfil, Integer> {
    
    public Optional<Perfil> findByNombre(String nombre);

}
