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
public interface SeccionRepository extends PagingAndSortingRepository<Seccion, Long> {

    public Seccion findById(Long cod_seccion);

    public Seccion findBySecNombre(String secNombre);

    public List<Seccion> findAll();

    public Page<Seccion> findByDocenteId(Long do_codigoDocente, Pageable pageable);

    @Query("SELECT s FROM Seccion s " +
           "JOIN s.proyectos p " +
           "JOIN p.entregables e " +
           "JOIN e.entregableEstudiantes ee " +
           "WHERE ee.estudiante.id = :estudianteId")
    public Page<Seccion> findSeccionesByEstudianteId(@Param("estudianteId") Long estudianteId, Pageable pageable);
}

