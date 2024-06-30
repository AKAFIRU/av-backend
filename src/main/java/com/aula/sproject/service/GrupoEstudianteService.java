
package com.aula.sproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.aula.sproject.entity.GrupoEstudiante;
import com.aula.sproject.repository.GrupoEstudianteRepository;

@Service
public class GrupoEstudianteService {

    @Autowired
    GrupoEstudianteRepository grupoestudianteRepository;

    public Page<GrupoEstudiante> findAll(Integer pageNo, Integer pageSize) {

        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<GrupoEstudiante> grupoestudiante = grupoestudianteRepository.findAll(pageable);
        return grupoestudiante;
    }

    public void deleteById(Long id) {
        grupoestudianteRepository.deleteById(id);
    }

    public GrupoEstudiante findById(Long id) {
        return grupoestudianteRepository.findById(id);
    }

    public void save(GrupoEstudiante grupoestudiante) {
        grupoestudianteRepository.save(grupoestudiante);
}

}