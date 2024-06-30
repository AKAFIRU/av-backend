
package com.aula.sproject.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.aula.sproject.entity.Docente;

@Repository
public interface DocenteRepository extends PagingAndSortingRepository<Docente, Long> {

    public Docente findById(Long do_codigoDocente);

    public Docente findByNombre(String do_nombre);

    public void save(Docente docente);

	public  void deleteById(long id);

}