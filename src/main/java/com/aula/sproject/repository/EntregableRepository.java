package com.aula.sproject.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.aula.sproject.entity.Entregable;

@Repository
public interface EntregableRepository extends PagingAndSortingRepository<Entregable,Long> {

    
}