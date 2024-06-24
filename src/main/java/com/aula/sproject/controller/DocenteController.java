package com.aula.sproject.controller;

import com.aula.sproject.service.DocenteService;
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
        result.put("data", docenteService.findAll(0,20));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}