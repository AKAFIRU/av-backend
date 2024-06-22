package com.aula.sproject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
    @Column(name = "ge_idgrupoEstudiante")
    private Long id;

    @Column(name = "ge_nombregrupo")
    private String nombreGrupo;

    @Column(name = "ge_numerointegrantes")
    private Integer numeroIntegrantes;

    @Column(name = "ge_nombreproyecto")
    private String nombreProyecto;

    @Column(name = "ge_ciclo")
    private Integer ciclo;

}