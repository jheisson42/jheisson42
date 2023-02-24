package com.neoris.prueba.movimiento.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import com.neoris.prueba.entity.MovimientoEntity;

public interface IMovimientoService {

	public MovimientoEntity crearMovimiento(MovimientoEntity movimientoEntity) throws Exception;
	
	public List<MovimientoEntity> consultarMovimientoId(Integer id) throws Exception;

	public Iterable<MovimientoEntity> consultarMovimientos() throws Exception;

	public String eliminarMovimiento(Integer id) throws Exception;

	public Map<String, Object> generarReporte(Integer idMovimiento, LocalDate fechaInicio, LocalDate fechaFin);
	
}
