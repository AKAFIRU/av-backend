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

import com.aula.sproject.entity.Curso;
import com.aula.sproject.service.CursoService;

import io.swagger.annotations.ApiOperation;

@Controller
@RestController
@RequestMapping("/cursos")
public class CursoController {
    @Autowired
    CursoService cursoService;

    @ApiOperation(value = "Lista de cursos")
    @GetMapping
    public ResponseEntity<?> findAllCursos() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put("message", "Lista de cursos");
        result.put("data", cursoService.findAll(0, 20));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put("message", "Lista de cursos");
        result.put("data", cursoService.findById(id));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Curso curso) {
        cursoService.save(curso); 
        HashMap<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put("message", "Curso registrado correctamente");
        result.put("data", curso); 

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

@PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody Curso curso) {
        HashMap<String, Object> result = new HashMap<>();
        Curso data = cursoService.findById(id);
        if (data == null) {
            result.put("success", false);
            result.put("message", "No existe registro con Id: " + id);
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
        try {
            curso.setId(id);
            cursoService.save(curso);
            result.put("success", true);
            result.put("message", "Datos actualizados correctamente.");
            result.put("data", curso);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(new Exception(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        HashMap<String, Object> result = new HashMap<>();
        
        // Busca el curso por ID
        Curso curso = cursoService.findById(id);
        
        if (curso == null) {
            // Si no se encuentra el curso, devuelve un mensaje de error
            result.put("success", false);
            result.put("message", "No existe curso con id: " + id);
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        } else {
            // Si se encuentra el curso, procede a eliminarlo
            cursoService.deleteById(id);
            result.put("success", true);
            result.put("message", "Curso eliminado correctamente");
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }

}