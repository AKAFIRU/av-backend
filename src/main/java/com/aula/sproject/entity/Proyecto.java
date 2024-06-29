package com.aula.sproject.entity;

import java.util.Date;

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
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table (name = "proyecto")
public class Proyecto {

@Id
@Column (name = "pro_idProyecto")
private Long id;

@Column (name = "pro_nombre")
private String proyectoNombre;

@Column (name = "pro_fechaFinal")
private Date fechaFinal;

@Column (name = "pro_fechaCreacion")
private Date fechaCreacion;


}