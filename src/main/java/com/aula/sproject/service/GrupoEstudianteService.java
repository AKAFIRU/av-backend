
package com.aula.sproject.service;

import com.aula.sproject.entity.GrupoEstudiante;
import com.aula.sproject.repository.GrupoEstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class GrupoEstudianteService {

@Autowired
GrupoEstudianteRepository grupoestudianteRepository;

Page <GrupoEstudiante> findAll(Integer pageNo, Integer pageSize ){

 Pageable pageable = PageRequest.of(pageNo, pageSize);
 Page<GrupoEstudiante> grupoestudiante = grupoestudianteRepository.findAll(pageable);

}
    
}