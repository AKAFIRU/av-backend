package com.aula.sproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.aula.sproject.entity.Estudiante;
import com.aula.sproject.repository.EstudianteRepository;

@Service
public class EstudianteService {

    @Autowired
    EstudianteRepository estudianteRepository;

    public Page<Estudiante> findAll(Integer pageNo, Integer pageSize) {

        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Estudiante> estudiante = estudianteRepository.findAll(pageable);
        return estudiante;
    }

public void deleteById(Long id) {
        estudianteRepository.deleteById(id);
    }

    public Estudiante findById(Long id) {
        return estudianteRepository.findById(id);
    }

    public void save(Estudiante estudiante) {
        estudianteRepository.save(estudiante);
}

}
