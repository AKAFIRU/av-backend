package com.aula.sproject.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.aula.sproject.entity.GrupoEstudiante;

@Repository
public interface GrupoEstudianteRepository extends PagingAndSortingRepository<GrupoEstudiante, Long> {

    public GrupoEstudiante findById(Long ge_idgrupoEstudiante);

    public GrupoEstudiante findByNombreGrupo(String ge_nombregrupo);

     public void save(GrupoEstudiante grupoestudiante);

	public  void deleteById(long id);

}