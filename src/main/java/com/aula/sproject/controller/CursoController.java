package com.aula.sproject.controller;

import com.aula.sproject.service.CursoService;
import io.swagger.annotations.ApiOperation;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        result.put("data", cursoService.findAll(0,20));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

   
}