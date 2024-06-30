package com.aula.sproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.aula.sproject.entity.Curso;
import com.aula.sproject.repository.CursoRepository;

@Service
public class CursoService {
    @Autowired
    CursoRepository cursoRepository;

    public Page<Curso> findAll(Integer pageNo, Integer pageSize) {

        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Curso> curso = cursoRepository.findAll(pageable);

        return curso;

        
    }
    public void deleteById(Long id) {
        cursoRepository.deleteById(id);
    }

    public Curso findById(Long id) {
        return cursoRepository.findById(id);
    }



    



    
public void save(Curso curso) {
		this.cursoRepository.save(curso);
}}
