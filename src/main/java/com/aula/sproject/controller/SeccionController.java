package com.aula.sproject.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aula.sproject.entity.Seccion;
import com.aula.sproject.service.SeccionService;

import io.swagger.annotations.ApiOperation;

@Controller
@RestController
@RequestMapping("/seccion")
public class SeccionController {

    @Autowired
    SeccionService seccionService;

    @ApiOperation(value ="Lista de Secciones")
    @GetMapping
    public ResponseEntity<?> findAllCursos() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put("message", "Lista de secciones");
        result.put("data", seccionService.findAll(0,20));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

   @GetMapping("/{id}")
    public ResponseEntity<Page<Seccion>> findByDocenteId(@PathVariable Long id, Pageable pageable) {
        Page<Seccion> secciones = seccionService.findByDocenteId(id, pageable);
        return ResponseEntity.ok(secciones);
    }

    @GetMapping("/estudiante/{estudianteId}")
    public Page<Seccion> getSeccionesByEstudianteId(@PathVariable Long estudianteId,
                                                    @RequestParam int page,
                                                    @RequestParam int size) {
        Pageable pageable = PageRequest.of(page, size);
        return seccionService.getSeccionesByEstudianteId(estudianteId, pageable);
    }
    
}