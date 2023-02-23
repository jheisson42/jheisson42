package com.neoris.prueba.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "personas")
@Inheritance(strategy = InheritanceType.JOINED)
public class PersonaEntity {

    @Id
    @Column(name = "identidad")
	private String identidad;
    
    @Column(name = "nombres")
	private String nombres;
    
    @Column(name = "genero")
	private String genero;
    
    @Column(name = "edad")
	private String edad;
    
    @Column(name = "direccion")
	private String direccion;
    
    @Column(name = "telefono")
	private String telefono;

}
