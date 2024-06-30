package com.aula.sproject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "grupo_estudiante")
public class GrupoEstudiante {
    @Id
    @Column(name = "ge_id")
    private Long id;

    @Column(name = "ge_nombregrupo")
    private String nombreGrupo;

    @Column(name = "ge_numerointegrantes")
    private Integer numeroIntegrantes;

    @ManyToOne
    @JoinColumn(name = "cod_estudiante")
    private Estudiante estudiante;
}
