package com.aula.sproject.controller;

import com.aula.sproject.entity.Docente;
import com.aula.sproject.service.DocenteService;
import io.swagger.annotations.ApiOperation;
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
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
public class DocenteController {

@Autowired
    DocenteService docenteService;

    @ApiOperation(value = "Lista de docentes")
    @GetMapping
    public ResponseEntity<?> findAll() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put("message", "Lista de docentes");
        result.put("data", docenteService.findAll());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtienes datos de un docente")
    @GetMapping("/{id}")
    public ResponseEntity<Docente> findById(@PathVariable Long id) {
        Docente docente = docenteService.findById(id);
        return ResponseEntity.ok(docente);
    }

    
    @ApiOperation(value = "Regista un docente")
    @PostMapping
    public ResponseEntity<?> save(@RequestBody Docente docente) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put("message", "Persona registrado correctamente");
        result.put("data", docenteService.save(docente));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    
    @ApiOperation(value = "Modifica un docente")
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
    
    @ApiOperation(value = "Elimina un docente")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        HashMap<String, Object> result = new HashMap<>();
    Docente data = docenteService.findById(id);
    if(data == null){
        result.put("success", false);
        result.put("message", "No existe docente con id:" + id);
  return new ResponseEntity <>(result, HttpStatus.NOT_FOUND);
    } else{
  docenteService.deleteById(id);
            result.put("success", true);
            result.put("message", "Registro Eliminado correctamente");
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }
    

}