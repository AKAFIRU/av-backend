package com.aula.sproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.aula.sproject.entity.Seccion;
import com.aula.sproject.repository.SeccionRepository;

@Service
public class SeccionService {

    @Autowired
    SeccionRepository seccionRepository;

    public Page<Seccion> findAll(Integer pageNo, Integer pageSize) {

        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Seccion> seccion = seccionRepository.findAll(pageable);

        return seccion;
    }

    public Page<Seccion> findByDocenteId(Long docenteId, Pageable pageable) {
        return seccionRepository.findByDocenteId(docenteId, pageable);
    }

    public Page<Seccion> getSeccionesByEstudianteId(Long estudianteId, Pageable pageable) {
        return seccionRepository.findSeccionesByEstudianteId(estudianteId, pageable);
    }

}