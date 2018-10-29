package com.quat.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.quat.model.Proyecto;

@Transactional
public interface ProyectoRepository extends CrudRepository<Proyecto, Integer> {
    
    @Query(value="select * from proyecto where activo=1;", nativeQuery=true)
    public Iterable<Proyecto> activos();

}
