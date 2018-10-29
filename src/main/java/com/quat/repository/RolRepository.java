package com.quat.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.quat.model.Rol;

@Transactional
public interface RolRepository extends CrudRepository<Rol, Integer> {
    
    @Query(value="select r.* from rol as r join perfil_roles as pr on r.id=pr.roles_id join perfil as p on p.id=pr.perfil_id join usuario as u on u.perfil_id=p.id where u.id=:id_usuario;", nativeQuery=true)
    public Iterable<Rol> roles(@Param("id_usuario") Integer id_usuario);

}
