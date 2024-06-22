package com.aula.sproject.repository;

import com.aula.sproject.entity.GrupoEstudiante;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrupoEstudianteRepository extends PagingAndSortingRepository<GrupoEstudiante,Long> {

    
}