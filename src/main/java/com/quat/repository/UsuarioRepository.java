package com.quat.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.quat.model.Usuario;

@Transactional
public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {
    
    public boolean existsByPersonalId(Integer personal_id);

}
