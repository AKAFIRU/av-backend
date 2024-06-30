package com.aula.sproject.repository;

import com.aula.sproject.entity.Proyecto;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyectoRepository extends PagingAndSortingRepository<Proyecto, Long> {

    public Proyecto findById(Long pro_idProyecto);

    public Proyecto findByProyectoNombre(String pro_nombre);

}