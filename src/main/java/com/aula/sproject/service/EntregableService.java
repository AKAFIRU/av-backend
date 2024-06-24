package com.aula.sproject.service;

import com.aula.sproject.entity.Entregable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aula.sproject.repository.EntregableRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@Service
public class EntregableService {
    @Autowired
    EntregableRepository entregableRepository;

    public Page<Entregable> findAll(Integer pageNo, Integer pageSize) {

        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Entregable> entregable = entregableRepository.findAll(pageable);
        return entregable;
    }

}