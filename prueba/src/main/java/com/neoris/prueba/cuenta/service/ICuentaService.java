package com.neoris.prueba.cuenta.service;

import com.neoris.prueba.entity.CuentaEntity;

public interface ICuentaService {

	public CuentaEntity crearCuenta(CuentaEntity cuentaEntity) throws Exception;
	
	public CuentaEntity consultarCuentaId(String id) throws Exception;

	public Iterable<CuentaEntity> consultarCuentas() throws Exception;

	public String eliminarCuenta(String id) throws Exception;
	
}
