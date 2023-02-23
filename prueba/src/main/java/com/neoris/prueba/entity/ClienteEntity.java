package com.neoris.prueba.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "clientes")
@PrimaryKeyJoinColumn(referencedColumnName = "identidad")
public class ClienteEntity extends PersonaEntity {

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_cliente")
	private String idcliente;

    @Column(name = "password")
	private String password;

    @Column(name = "estado")
	private String estado;

    @Column(name = "identidad")
	private String identidad;
    
}
