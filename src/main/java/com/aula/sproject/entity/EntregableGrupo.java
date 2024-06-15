package com.aula.sproject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "entregable_grupo")
public class EntregableGrupo {
    @Id
    @Column(name = "ge_idgrupoEstudiante")
    private Long grupoEstudianteId;
}