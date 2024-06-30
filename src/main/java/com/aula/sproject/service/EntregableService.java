package com.aula.sproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.aula.sproject.entity.Entregable;
import com.aula.sproject.repository.EntregableRepository;

@Service
public class EntregableService {
    @Autowired
    EntregableRepository entregableRepository;

    public Page<Entregable> findAll(Integer pageNo, Integer pageSize) {

        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Entregable> entregable = entregableRepository.findAll(pageable);
        return entregable;
    }

    public void deleteById(Long id) {
        entregableRepository.deleteById(id);
    }

    public Entregable findById(Long id) {
        return entregableRepository.findById(id);
    }

    public void save(Entregable entregable) {
        entregableRepository.save(entregable);
}
}