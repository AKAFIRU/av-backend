package com.aula.sproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.aula.sproject.entity.Proyecto;
import com.aula.sproject.repository.ProyectoRepository;

@Service
public class ProyectoService {

    @Autowired
    ProyectoRepository proyectoRepository;

    public Page<Proyecto> findAll(Integer pageNo, Integer pageSize) {

        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Proyecto> proyecto = proyectoRepository.findAll(pageable);
        return proyecto;
    }

    public void deleteById(Long id) {
        proyectoRepository.deleteById(id);
    }

    public Proyecto findById(Long id) {
        return proyectoRepository.findById(id);
    }

    public void save(Proyecto proyecto) {
        proyectoRepository.save(proyecto);
    }

    
    public Page<Proyecto> buscarPorIdSeccion(Long idSeccion , Pageable pageable) {
        return proyectoRepository.findBySeccionId(idSeccion, pageable);
    }

    public Page<Proyecto> getProyectosByDocenteId(Long docenteId, Pageable pageable) {
        return proyectoRepository.findProyectosByDocenteId(docenteId, pageable);
    }

}