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



@Entity
@Data
@Table(name = "seccionProyecto")
@NoArgsConstructor
@AllArgsConstructor
public class SeccionProyecto {


    @Id
    @Column(name = "cod_seccion_proyecto")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cod_seccion")
    private Seccion seccion;

    @ManyToOne
    @JoinColumn(name = "pro_idProyecto")
    private Proyecto proyecto;

}

