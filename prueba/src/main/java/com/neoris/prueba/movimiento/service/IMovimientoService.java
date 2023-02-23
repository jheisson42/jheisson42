package com.neoris.prueba.movimiento.service;

import java.util.List;

import com.neoris.prueba.entity.MovimientoEntity;

public interface IMovimientoService {

	public MovimientoEntity crearMovimiento(MovimientoEntity movimientoEntity) throws Exception;
	
	public List<MovimientoEntity> consultarMovimientoId(Integer id) throws Exception;

	public Iterable<MovimientoEntity> consultarMovimientos() throws Exception;

	public String eliminarMovimiento(Integer id) throws Exception;
	
}
