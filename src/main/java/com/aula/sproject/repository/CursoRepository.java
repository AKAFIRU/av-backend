
package com.aula.sproject.repository;

import com.aula.sproject.entity.Curso;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends PagingAndSortingRepository<Curso, Long> {

    public Curso findById(Long cur_codigoCurso);

    public Curso findByCursoNombre(String cursoNombre);

    public List<Curso> findAll();
}