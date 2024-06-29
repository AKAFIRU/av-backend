package com.aula.sproject.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "entregable_estudiante")
@NoArgsConstructor
@AllArgsConstructor

public class EntregableEstudiante {


    @Id
    @Column(name = "codes_entregable")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "es_codigoEstudiante")
    private Estudiante estudiante;

    @Column(name = "codes_fecha")
    private Date fechaEntrega;

    @Column(name = "entregable")
    private byte entregable;
}
