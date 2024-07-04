package com.aula.sproject.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.aula.sproject.entity.Proyecto;

@Repository
public interface ProyectoRepository extends PagingAndSortingRepository<Proyecto, Long> {

    public Proyecto findById(Long pro_idProyecto);

    public Proyecto findByProyectoNombre(String pro_nombre);

     public void save(Proyecto proyecto);

	public  void deleteById(long id);

    @Query("SELECT p FROM Proyecto p JOIN p.seccions s WHERE s.id = :seccionId")
    public Page<Proyecto> findBySeccionId(@Param("seccionId") Long seccionId, Pageable pageable);

}