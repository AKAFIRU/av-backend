package com.aula.sproject.service;

import com.aula.sproject.entity.Docente;
import com.aula.sproject.repository.DocenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DocenteService {

    @Autowired
    DocenteRepository docenteRepository;

    public Page<Docente> findAll(Integer pageNo, Integer pageSize) {

        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Docente> docente = docenteRepository.findAll(pageable);
        return docente;
    }
}
