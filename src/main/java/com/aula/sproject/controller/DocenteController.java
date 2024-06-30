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

import com.aula.sproject.entity.Docente;
import com.aula.sproject.service.DocenteService;

import io.swagger.annotations.ApiOperation;

@Controller
@RestController
@RequestMapping("/docentes")
public class DocenteController {

    @Autowired
    DocenteService docenteService;

    @ApiOperation(value = "Lista de docentes")
    @GetMapping
    public ResponseEntity<?> findAllDocentes() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put("message", "Lista de docentes");
        result.put("data", docenteService.findAll(0, 20));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Docente> findById(@PathVariable Long id) {
        Docente docente = docenteService.findById(id);
        return ResponseEntity.ok(docente);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Docente docente) {
        docenteService.save(docente); 

        
        HashMap<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put("message", "Docente registrado correctamente");
        result.put("data", docente);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

@PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody Docente docente) {
        HashMap<String, Object> result = new HashMap<>();
        Docente data = docenteService.findById(id);
        if (data == null) {
            result.put("success", false);
            result.put("message", "No existe registro con Id: " + id);
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
        try {
            docente.setId(id);
            docenteService.save(docente);
            result.put("success", true);
            result.put("message", "Datos actualizados correctamente.");
            result.put("data", docente);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(new Exception(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        HashMap<String, Object> result = new HashMap<>();
        
        // Busca el curso por ID
        Docente docente = docenteService.findById(id);
        
        if (docente == null) {
            // Si no se encuentra el curso, devuelve un mensaje de error
            result.put("success", false);
            result.put("message", "No existe docente con id: " + id);
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        } else {
            // Si se encuentra el curso, procede a eliminarlo
            docenteService.deleteById(id);
            result.put("success", true);
            result.put("message", "docente eliminado correctamente");
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }


}