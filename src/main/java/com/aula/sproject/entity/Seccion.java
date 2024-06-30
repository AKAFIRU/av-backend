package com.aula.sproject.entity;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "seccion")
@NoArgsConstructor
@AllArgsConstructor
public class Seccion {

    @Id
    @Column(name = "cod_seccion")
    private Long id;

    @Column(name = "sec_nombre")
    private String secNombre;

    @ManyToOne
    @JoinColumn(name = "cu_id")
    private Curso curso;

    @ManyToOne
    @JoinColumn(name = "do_id")
    private Docente docente;

    @ManyToMany(mappedBy = "seccions")
    Set<Proyecto> proyectos;

}
