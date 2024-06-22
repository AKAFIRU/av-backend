package com.aula.sproject.service;

import com.aula.sproject.entity.Docente;
import com.aula.sproject.repository.CursoRepository;
import com.aula.sproject.repository.DocenteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DocenteService{

@Autowired
DocenteRepository docenteRepository;

Page <Docente> findAll(Integer pageNo, Integer pageSize ){

 Pageable pageable = PageRequest.of(pageNo, pageSize);
 Page<Docente> docente = docenteRepository.findAll(pageable);

}
}


