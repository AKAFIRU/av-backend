package com.aula.sproject.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.aula.sproject.entity.Estudiante;

@Repository
public interface EstudianteRepository extends PagingAndSortingRepository<Estudiante, Long> {

    Estudiante findById (Long es_codigoEstudiante);
    
    Estudiante findByNombre (String es_nombre);    

}