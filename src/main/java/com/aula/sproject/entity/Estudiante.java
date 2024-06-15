package com.aula.sproject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Estudiante")
public class Estudiante {
    @Id
    @Column(name = "es_codigoEstudiante")
    private Long codigoEstudiante;

    @Column(name = "es_nombre")
    private String nombre;

    @Column(name = "es_apellido")
    private String apellido;

    @Column(name = "es_correo")
    private String correo;
}