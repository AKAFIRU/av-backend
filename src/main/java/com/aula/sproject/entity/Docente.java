package com.aula.sproject.entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
@Table(name = "docente")
public class Docente {

    @Id
    @Column(name = "do_id")
    private Long id;

    @Column(name = "do_nombre")
    private String nombre;

    @Column(name = "do_apellido")
    private String apellido;

    @Column(name = "do_correo")
    private String correo;

    @Column(name = "do_codigo_insti")
    private String codigoInsti;

    @OneToMany(mappedBy = "docente", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Seccion> seccions;

}