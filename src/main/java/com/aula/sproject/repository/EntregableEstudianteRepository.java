package com.aula.sproject.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.aula.sproject.entity.EntregableEstudiante;


@Repository
public interface EntregableEstudianteRepository extends PagingAndSortingRepository<EntregableEstudiante, Long> {

public EntregableEstudiante findById (Long codes_entregable);


Page<EntregableEstudiante> findByCursoId(Long cur_codigoCurso, Pageable pageable);

Page<EntregableEstudiante> findByEstudianteId(Long es_codigoEstudiante, Pageable pageable);


}
