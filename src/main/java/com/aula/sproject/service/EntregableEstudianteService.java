package com.aula.sproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.aula.sproject.entity.EntregableEstudiante;
import com.aula.sproject.repository.EntregableEstudianteRepository;

@Service
public class EntregableEstudianteService {

    @Autowired
    private EntregableEstudianteRepository entregableEstudianteService;

    public EntregableEstudiante save(EntregableEstudiante entregableEstudiante) {
         return entregableEstudianteService.save(entregableEstudiante);
    }

    public Page<EntregableEstudiante> findAll(Integer pageNo, Integer pageSize) {

        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<EntregableEstudiante> entregable = entregableEstudianteService.findAll(pageable);
        return entregable;
    }
    
}
