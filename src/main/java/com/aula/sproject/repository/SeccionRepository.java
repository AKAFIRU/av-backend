package com.aula.sproject.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.aula.sproject.entity.Seccion;

@Repository
public interface SeccionRepository extends PagingAndSortingRepository<Seccion, Long>{

    Seccion findById (Long cod_seccion);
    
    Seccion findBySecNombre(String secNombre);

    List<Seccion> findAll();

    Page <Seccion> findByDocenteId(Long do_codigoDocente, Pageable pageable);

    @Query("SELECT s FROM Seccion s INNER JOIN s.curso c INNER JOIN c.seccionProyectos sp" +
    "INNER JOIN sp.proyecto p " +
    "INNER JOIN p.entregables e INNER JOIN e.entregableEstudiantes ee WHERE ee.estudiante.id = :estudianteId")
    Page <Seccion> findSeccionesByEstudianteId(@Param("estudianteId") Long estudianteId);
}
