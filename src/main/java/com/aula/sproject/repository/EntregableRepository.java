package com.aula.sproject.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.aula.sproject.entity.Entregable;

@Repository
public interface EntregableRepository extends PagingAndSortingRepository<Entregable,Long> {

    public Entregable findById (Long cod_entregable);
    
    public Entregable findByCodigoProyecto(Long cod_proyecto);

    public List<Entregable> findAll();
    
}