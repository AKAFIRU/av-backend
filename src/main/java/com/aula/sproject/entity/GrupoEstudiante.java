package com.aula.sproject.entity;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ge_id")
    private Long id;

    @Column(name = "ge_nombregrupo")
    private String nombreGrupo;

    @Column(name = "ge_numerointegrantes")
    private Integer numeroIntegrantes;

    @ManyToMany(mappedBy = "grupoEstudiantes")
    private Set<Estudiante> estudiantes;
}
