package com.aula.sproject.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aula.sproject.entity.Proyecto;
import com.aula.sproject.service.ProyectoService;

import io.swagger.annotations.ApiOperation;

@Controller
@RestController
@RequestMapping("/proyectos")
public class ProyectoController {

    @Autowired
    ProyectoService proyectoService;

    @ApiOperation(value = "Lista de proyectos")
    @GetMapping
    public ResponseEntity<?> findAllProyectos() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put("message", "Lista de proyectos");
        result.put("data", proyectoService.findAll(0, 20));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Proyecto> findById(@PathVariable Long id) {
        Proyecto proyecto = proyectoService.findById(id);
        return ResponseEntity.ok(proyecto);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Proyecto proyecto) {
        proyectoService.save(proyecto); 

        
        HashMap<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put("message", "Proyecto registrado correctamente");
        result.put("data", proyecto);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

@PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody Proyecto proyecto) {
        HashMap<String, Object> result = new HashMap<>();
        Proyecto data = proyectoService.findById(id);
        if (data == null) {
            result.put("success", false);
            result.put("message", "No existe registro con Id: " + id);
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
        try {
            proyecto.setId(id);
            proyectoService.save(proyecto);
            result.put("success", true);
            result.put("message", "Datos actualizados correctamente.");
            result.put("data", proyecto);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(new Exception(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        HashMap<String, Object> result = new HashMap<>();
        
        Proyecto proyecto = proyectoService.findById(id);
        
        if (proyecto == null) {
            result.put("success", false);
            result.put("message", "No existe proyecto con id: " + id);
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        } else {
            proyectoService.deleteById(id);
            result.put("success", true);
            result.put("message", "proyecto eliminado correctamente");
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }



}