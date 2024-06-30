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

@Entity
@Data
@Table(name = "curso")
@NoArgsConstructor
@AllArgsConstructor
public class Curso {

    @Id
    @Column(name = "cu_id")
    private Long id;

    @Column(name = "cur_nombre")
    private String cursoNombre;

    @Column(name = "cur_ciclo")
    private Integer ciclo;


    @Column(name = "cur_silabo", nullable = true)
    private Byte cursoSilabo;

    @OneToMany(mappedBy = "curso")
    private Set<Seccion> seccions;

}