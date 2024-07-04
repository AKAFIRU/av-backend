package com.aula.sproject.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.aula.sproject.entity.EntregableEstudiante;
import com.aula.sproject.serializable.EntregableEstudianteId;



@Repository
public interface EntregableEstudianteRepository extends PagingAndSortingRepository <EntregableEstudiante, EntregableEstudianteId>{
    public EntregableEstudiante save(EntregableEstudiante entregableEstudiante);
}
