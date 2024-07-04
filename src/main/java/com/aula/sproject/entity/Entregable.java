package com.aula.sproject.entity;

import java.util.Date;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "entregable")
public class Entregable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_entregable")
    private Long id;

    @Column(name = "cod_fecha_cre")
    private Date fechaCre;

    @Column(name = "cod_fecha_li")
    private Date fechaLimite;

    @ManyToOne
    @JoinColumn(name = "pro_id")
    private Proyecto proyecto;

    @OneToMany(mappedBy = "entregable")
    Set<EntregableEstudiante> entregableEstudiantes;

}