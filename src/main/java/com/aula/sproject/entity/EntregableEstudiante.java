package com.aula.sproject.entity;

import java.util.Date;

import com.aula.sproject.serializable.EntregableEstudianteId;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "entregable_estudiante")
@NoArgsConstructor
@AllArgsConstructor
public class EntregableEstudiante {

    @EmbeddedId
    private EntregableEstudianteId id;

    @ManyToOne
    @MapsId("entregableId")
    @JoinColumn(name = "cod_entregable")
    private Entregable entregable;

    @ManyToOne
    @MapsId("estudianteId")
    @JoinColumn(name = "cod_estudiante")
    private Estudiante estudiante;

    @Column(name = "codes_fecha", nullable = true)
    private Date fechaEntrega;

    @Column(name = "en_tarea", nullable = true)
    private Byte tareaEntregable;

    @Column(name = "en_comentario", nullable = true)
    private String comentario;

    @Column(name = "en_nota", nullable = true)
    private Integer nota;

}
