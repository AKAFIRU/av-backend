package com.aula.sproject.service;

import com.aula.sproject.entity.Estudiante;
import com.aula.sproject.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EstudianteService {

    @Autowired
    EstudianteRepository estudianteRepository;

    public Page<Estudiante> findAll(Integer pageNo, Integer pageSize) {

        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Estudiante> estudiante = estudianteRepository.findAll(pageable);
        return estudiante;
    }
}
