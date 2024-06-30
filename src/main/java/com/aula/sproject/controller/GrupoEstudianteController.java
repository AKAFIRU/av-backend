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

import com.aula.sproject.entity.GrupoEstudiante;
import com.aula.sproject.service.GrupoEstudianteService;

import io.swagger.annotations.ApiOperation;

@Controller
@RestController
@RequestMapping("/grupoestudiantes")
public class GrupoEstudianteController {

    @Autowired
    GrupoEstudianteService grupoestudianteService;

    @ApiOperation(value = "Lista de grupos de estudiantes")
    @GetMapping
    public ResponseEntity<?> findAllGrupoEstudiantes() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put("message", "Lista de grupo de estudiantes");
        result.put("data", grupoestudianteService.findAll(0, 20));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GrupoEstudiante> findById(@PathVariable Long id) {
        GrupoEstudiante grupoestudiante = grupoestudianteService.findById(id);
        return ResponseEntity.ok(grupoestudiante);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody GrupoEstudiante grupoestudiante) {
        grupoestudianteService.save(grupoestudiante); 

        
        HashMap<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put("message", "Grupo de estudiantes registrado correctamente");
        result.put("data", grupoestudiante);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

@PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody GrupoEstudiante grupoestudiante) {
        HashMap<String, Object> result = new HashMap<>();
        GrupoEstudiante data = grupoestudianteService.findById(id);
        if (data == null) {
            result.put("success", false);
            result.put("message", "No existe registro con Id: " + id);
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
        try {
            grupoestudiante.setId(id);
            grupoestudianteService.save(grupoestudiante);
            result.put("success", true);
            result.put("message", "Datos actualizados correctamente.");
            result.put("data", grupoestudiante);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(new Exception(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        HashMap<String, Object> result = new HashMap<>();
        
        // Busca el curso por ID
        GrupoEstudiante grupoestudiante = grupoestudianteService.findById(id);
        
        if (grupoestudiante == null) {
            // Si no se encuentra el curso, devuelve un mensaje de error
            result.put("success", false);
            result.put("message", "No existe grupo de estudiantes con id: " + id);
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        } else {
            // Si se encuentra el curso, procede a eliminarlo
            grupoestudianteService.deleteById(id);
            result.put("success", true);
            result.put("message", "grupo de estudiantes eliminado correctamente");
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }



}