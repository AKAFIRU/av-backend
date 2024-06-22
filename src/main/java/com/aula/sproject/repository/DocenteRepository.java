

package com.aula.sproject.repository;

import com.aula.sproject.entity.Docente;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocenteRepository extends PagingAndSortingRepository<Docente,Long>{

    
}