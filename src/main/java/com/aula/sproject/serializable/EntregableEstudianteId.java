package com.aula.sproject.serializable;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class EntregableEstudianteId implements Serializable {

    @Column(name = "cod_entregable")
    Long entregableId;

    @Column(name = "cod_estudiante")
    Long estudianteId;

}
