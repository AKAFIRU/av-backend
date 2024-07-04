package com.aula.sproject.service;

import org.springframework.beans.factory.annotation.Autowired;
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
    
}
