package com.aula.sproject.entity;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "estudiante")
public class Estudiante {
    @Id
    @Column(name = "cod_estudiante")
    private Long id;

    @Column(name = "es_nombre")
    private String nombre;

    @Column(name = "es_apellido")
    private String apellido;

    @Column(name = "es_correo")
    private String correo;

    @Column(name = "es_codigoInsti")
    private String codigoInsti;

    @OneToMany(mappedBy = "estudiante")
    private Set<EntregableEstudiante> entregableEstudiantes;

    @OneToMany(mappedBy = "estudiante")
    private Set<GrupoEstudiante> grupoEstudiantes;
}