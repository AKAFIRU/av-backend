package com.aula.sproject.repository;

import com.aula.sproject.entity.EntregableGrupo;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntregableGrupoRepository extends PagingAndSortingRepository<EntregableGrupo,Long> {

    
}