package com.aula.sproject.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.aula.sproject.entity.Proyecto;

@Repository
public interface ProyectoRepository extends PagingAndSortingRepository<Proyecto, Long> {

    public Proyecto findById(Long pro_idProyecto);

    public Proyecto findByProyectoNombre(String pro_nombre);

     public void save(Proyecto proyecto);

	public  void deleteById(long id);

}