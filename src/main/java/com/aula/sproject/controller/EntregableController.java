package com.aula.sproject.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}