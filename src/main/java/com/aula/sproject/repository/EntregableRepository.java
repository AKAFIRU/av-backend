package com.aula.sproject.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.aula.sproject.entity.Entregable;

@Repository
public interface EntregableRepository extends PagingAndSortingRepository<Entregable, Long> {

    public Entregable findById(Long cod_entregable);

    public List<Entregable> findAll();

    public void save(Entregable entregable);

	public  void deleteById(long id);

    @Query("SELECT e FROM Entregable e WHERE e.proyecto.id = :proyectoId")
    public Page<Entregable> findByProyectoId(@Param("proyectoId") Long proyectoId, Pageable pageable);


}