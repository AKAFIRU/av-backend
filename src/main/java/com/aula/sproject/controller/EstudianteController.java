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

import com.aula.sproject.entity.Estudiante;
import com.aula.sproject.service.EstudianteService;

import io.swagger.annotations.ApiOperation;

@Controller
@RestController
@RequestMapping("/estudiantes")
public class EstudianteController {

    @Autowired
    EstudianteService estudianteService;

@ApiOperation(value = "Lista de estudiantes")
    @GetMapping
    public ResponseEntity<?> findAllEstudiantes() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put("message", "Lista de estudiantes");
        result.put("data", estudianteService.findAll(0, 20));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estudiante> findById(@PathVariable Long id) {
        Estudiante estudiante = estudianteService.findById(id);
        return ResponseEntity.ok(estudiante);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Estudiante estudiante) {
        estudianteService.save(estudiante); 

        
        HashMap<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put("message", "Estudiante registrado correctamente");
        result.put("data", estudiante);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

@PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody Estudiante estudiante) {
        HashMap<String, Object> result = new HashMap<>();
        Estudiante data = estudianteService.findById(id);
        if (data == null) {
            result.put("success", false);
            result.put("message", "No existe registro con Id: " + id);
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
        try {
            estudiante.setId(id);
            estudianteService.save(estudiante);
            result.put("success", true);
            result.put("message", "Datos actualizados correctamente.");
            result.put("data", estudiante);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(new Exception(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        HashMap<String, Object> result = new HashMap<>();
        
        // Busca el curso por ID
        Estudiante estudiante = estudianteService.findById(id);
        
        if (estudiante == null) {
            // Si no se encuentra el curso, devuelve un mensaje de error
            result.put("success", false);
            result.put("message", "No existe estudiante con id: " + id);
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        } else {
            // Si se encuentra el curso, procede a eliminarlo
            estudianteService.deleteById(id);
            result.put("success", true);
            result.put("message", "estudiante eliminado correctamente");
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }



}