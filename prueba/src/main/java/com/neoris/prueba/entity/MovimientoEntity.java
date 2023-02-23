package com.neoris.prueba.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "movimientos")
public class MovimientoEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_movimiento")
	private Integer idMovimiento;
	
	@Column(name = "fecha")
	private Date fecha;
	
	@Column(name = "num_cuenta")
	private Integer numCuenta;
	
	@Column(name = "tipo_movimiento")
	private String tipoMovimiento;
	
	@Column(name = "valor")
	private Integer valor;
	
	@Column(name = "saldo")
	private Integer saldo;
}
