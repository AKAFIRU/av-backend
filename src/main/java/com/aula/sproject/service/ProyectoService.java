package com.aula.sproject.service;

import com.aula.sproject.entity.Proyecto;
import com.aula.sproject.repository.CursoRepository;
import com.aula.sproject.repository.ProyectoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProyectoService {

@Autowired
ProyectoRepository proyectoRepository;

Page <Proyecto> findAll(Integer pageNo, Integer pageSize ){

 Pageable pageable = PageRequest.of(pageNo, pageSize);
 Page<Proyecto> proyecto = proyectoRepository.findAll(pageable);

}
}