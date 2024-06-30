package com.aula.sproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.aula.sproject.entity.Docente;
import com.aula.sproject.repository.DocenteRepository;

@Service
public class DocenteService {

    @Autowired
    DocenteRepository docenteRepository;

    public Page<Docente> findAll(Integer pageNo, Integer pageSize) {

        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Docente> docente = docenteRepository.findAll(pageable);
        return docente;
    }

     public void deleteById(Long id) {
        docenteRepository.deleteById(id);
    }

    public Docente findById(Long id) {
        return docenteRepository.findById(id);
    }

    public void save(Docente docente) {
        docenteRepository.save(docente);
}
}