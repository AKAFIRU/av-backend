package com.aula.sproject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@Table(name = "Curso")
@NoArgsConstructor
@AllArgsConstructor

public class Curso {

    @Id
    @Column(name = "cur_codigoCurso")
    private Long id;

    @Column(name = "cur_nombre")
    private String cursoNombre;

    @Column(name = "cur_silabo")
    private String cursoSilabo;

    }