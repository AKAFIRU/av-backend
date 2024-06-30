package com.aula.sproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.aula.sproject.entity.EntregableEstudiante;
import com.aula.sproject.repository.EntregableEstudianteRepository;

@Repository
public class EntregableEstudianteService {

    @Autowired
     EntregableEstudianteRepository entregableestudianteRepository;

     public Page<EntregableEstudiante> findAll(Integer pageNo, Integer pageSize) {

        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<EntregableEstudiante> entregableestudiante = entregableestudianteRepository.findAll(pageable);

        return entregableestudiante;
    }

    public Page<EntregableEstudiante> findByEstudianteId(Long estudianteId, Pageable pageable) {
        return entregableestudianteRepository.findByEstudianteId(estudianteId, pageable);
    }

}
