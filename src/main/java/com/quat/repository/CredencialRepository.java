package com.quat.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.quat.model.Credencial;

@Transactional
public interface CredencialRepository extends CrudRepository<Credencial, Integer> {
    
    @Query(value="select u.id from credencial as c join usuario as u on c.id=u.credencial_id where c.correo=:correo and c.contraseña=:contraseña limit 1;", nativeQuery=true)
    public Integer login(String correo, String contraseña);

    public boolean existsByCorreo(String correo);

}
