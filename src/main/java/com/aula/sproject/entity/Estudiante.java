package com.aula.sproject.entity;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @ManyToMany
    @JoinTable(name = "estudiante_grupo", joinColumns = @JoinColumn(name = "cod_estudiante"), inverseJoinColumns = @JoinColumn(name = "ge_id"))
    private Set<GrupoEstudiante> grupoEstudiantes;
}