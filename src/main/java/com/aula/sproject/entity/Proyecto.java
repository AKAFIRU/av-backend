package com.aula.sproject.entity;

import java.util.Date;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "proyecto")
public class Proyecto {

    @Id
    @Column(name = "pro_id")
    private Long id;

    @Column(name = "pro_nombre")
    private String proyectoNombre;

    @Column(name = "pro_fecha_finali")
    private Date fechaFinali;

    @Column(name = "pro_fecha_creacion")
    private Date fechaCreacion;

    @OneToMany(mappedBy = "proyecto", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Entregable> entregables;

    @ManyToMany
    @JoinTable(name = "seccion_proyecto", joinColumns = @JoinColumn(name = "pro_id"), inverseJoinColumns = @JoinColumn(name = "cod_seccion"))
    Set<Seccion> seccions;

}