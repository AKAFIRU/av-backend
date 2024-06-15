package com.aula.sproject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Getter
@Setter
@Table(name = "entregable")
public class Entregable {
    @Id
    @Column(name = "cod_entregable")
    private Long codigoEntregable;

    @Column(name = "cod_proyecto")
    private Long codigoProyecto;


}