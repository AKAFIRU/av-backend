package com.aula.sproject.repository;

import com.aula.sproject.entity.SeccionProyecto;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeccionProyectoRepository extends PagingAndSortingRepository<SeccionProyecto,Long> {

    
}