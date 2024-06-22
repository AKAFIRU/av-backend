package com.aula.sproject.service;

import com.aula.sproject.entity.Curso;
import com.aula.sproject.repository.CursoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CursoService{
@Autowired
CursoRepository cursoRepository;

Page <Curso> findAll(Integer pageNo, Integer pageSize ){

 Pageable pageable = PageRequest.of(pageNo, pageSize);
 Page<Curso> curso = cursoRepository.findAll(pageable);

}

}