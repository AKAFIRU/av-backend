
package com.aula.sproject.repository;

import com.aula.sproject.entity.Curso;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends PagingAndSortingRepository<Curso,Long>{

    public Curso findByCurso (String cur_codigoCurso);

    
} 