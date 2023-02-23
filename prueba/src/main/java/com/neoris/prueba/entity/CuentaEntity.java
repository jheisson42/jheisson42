package com.neoris.prueba.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cuentas")
public class CuentaEntity {

	@Id
	@Column(name = "num_cuenta")
	private Integer numCuenta;
	
	@Column(name = "saldo_inicial")
	private Integer saldoInicial;
	
	@Column(name = "estado")
	private String estado;
	
	@Column(name = "tipo_cuenta")
	private String tipoCuenta;
	
	@Column(name = "identidad")
	private String identidad;
}
