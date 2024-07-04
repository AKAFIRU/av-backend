package com.aula.sproject.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aula.sproject.entity.Entregable;
import com.aula.sproject.service.EntregableService;

import io.swagger.annotations.ApiOperation;

@Controller
@RestController
@RequestMapping("/entregables")
public class EntregableController {

    @Autowired
    EntregableService entregableService;

    @ApiOperation(value = "Lista de entregables")
    @GetMapping

    public ResponseEntity<?> findAllEntregables() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put("message", "Lista de entregables");
        result.put("data", entregableService.findAll(0, 20));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Entregable> findById(@PathVariable Long id) {
        Entregable entregable = entregableService.findById(id);
        return ResponseEntity.ok(entregable);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Entregable entregable) {
        entregableService.save(entregable);

        HashMap<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put("message", "Entregable registrado correctamente");
        result.put("data", entregable);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody Entregable entregable) {
        HashMap<String, Object> result = new HashMap<>();
        Entregable data = entregableService.findById(id);
        if (data == null) {
            result.put("success", false);
            result.put("message", "No existe registro con Id: " + id);
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
        try {
            entregable.setId(id);
            entregableService.save(entregable);
            result.put("success", true);
            result.put("message", "Datos actualizados correctamente.");
            result.put("data", entregable);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(new Exception(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        HashMap<String, Object> result = new HashMap<>();

        // Busca el curso por ID
        Entregable entregable = entregableService.findById(id);

        if (entregable == null) {
            // Si no se encuentra el curso, devuelve un mensaje de error
            result.put("success", false);
            result.put("message", "No existe entregable con id: " + id);
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        } else {
            // Si se encuentra el curso, procede a eliminarlo
            entregableService.deleteById(id);
            result.put("success", true);
            result.put("message", "entregable eliminado correctamente");
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }

    @GetMapping("/por-proyecto/{idProyecto}")
    public ResponseEntity<?> buscarPorIdSeccion(@PathVariable Long idProyecto,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "10") int size) {

        Pageable pageable = PageRequest.of(page, size);
        HashMap<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put("message", "Lista de proyectos");
        result.put("data", entregableService.buscarEntregablesPorIdProyecto(idProyecto, pageable));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}