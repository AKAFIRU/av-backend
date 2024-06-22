package com.aula.sproject.repository;

import com.aula.sproject.entity.Seccion;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeccionRepository extends PagingAndSortingRepository<Seccion,Long>{

    
}