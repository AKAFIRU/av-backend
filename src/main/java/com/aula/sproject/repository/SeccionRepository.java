package com.aula.sproject.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.aula.sproject.entity.Seccion;

@Repository
public interface SeccionRepository extends PagingAndSortingRepository<Seccion, Long>{

    public Seccion findById (Long cod_seccion);
    
    public Seccion findBySecNombre(String secNombre);

    public List<Seccion> findAll();

    Page <Seccion> findByDocenteId(Long do_codigoDocente, Pageable pageable);

    

    
}
