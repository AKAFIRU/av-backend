package com.aula.sproject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "Docente")
public class Docente {

@Id
@Column (name = "do_codigoDocente")
private Long id;

@Column (name = "do_nombre")
private String nombre;

@Column (name = "do_apellido")
private String apellido;

@Column (name = "do_correo")
private String correo;

@Column(name = "do_codigoInsti")
    private String codigoInsti;

    
}