package com.aula.sproject.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.aula.sproject.entity.EntregableEstudiante;
import com.aula.sproject.serializable.EntregableEstudianteId;
import com.aula.sproject.service.EntregableEstudianteService;
import com.aula.sproject.service.EntregableService;
import com.aula.sproject.service.EstudianteService;

@Controller
@RestController
@RequestMapping("/entregable-estudiante")
public class EntregableEstudianteController {

    @Autowired
    private EntregableEstudianteService entregableEstudianteService;
    @Autowired
    private EstudianteService estudianteService;
    @Autowired
    private EntregableService entregableService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file,
                                             @RequestParam("entregableId") Long entregableId,
                                             @RequestParam("estudianteId") Long estudianteId) {
        try {
            EntregableEstudianteId id = new EntregableEstudianteId(entregableId, estudianteId);
            EntregableEstudiante entregableEstudiante = new EntregableEstudiante();
            entregableEstudiante.setId(id);
            entregableEstudiante.setTareaEntregable(file.getBytes());
            entregableEstudiante.setEntregable(entregableService.findById(entregableId));
            entregableEstudiante.setEstudiante(estudianteService.findById(estudianteId));

            entregableEstudianteService.save(entregableEstudiante);
            return ResponseEntity.status(HttpStatus.OK).body("File uploaded successfully");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("File upload failed");
        }
    }
}
