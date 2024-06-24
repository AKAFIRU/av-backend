package com.aula.sproject.service;

import com.aula.sproject.entity.EntregableGrupo;
import com.aula.sproject.repository.EntregableGrupoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EntregableGrupoService {

    @Autowired
    EntregableGrupoRepository entregablegrupoRepository;

    public Page<EntregableGrupo> findAll(Integer pageNo, Integer pageSize) {

        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<EntregableGrupo> entregablegrupo = entregablegrupoRepository.findAll(pageable);
        return entregablegrupo;

    }

}