package com.neoris.prueba.movimiento.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neoris.prueba.cuenta.repository.ICuentaRepository;
import com.neoris.prueba.entity.CuentaEntity;
import com.neoris.prueba.entity.MovimientoEntity;
import com.neoris.prueba.movimiento.repository.IMovimientoRepository;

@Service
public class MovimientoService implements IMovimientoService {
	
	@Autowired
	private IMovimientoRepository movimientoRepository;  
	@Autowired
	private ICuentaRepository cuentaRepository;

	@Override
	public MovimientoEntity crearMovimiento(MovimientoEntity movimientoEntity) throws Exception {
		
		CuentaEntity cuenta = new CuentaEntity();
	  	Date date = new Date();  
	   	movimientoEntity.setFecha(date);		

		try {
			
			if (movimientoEntity.getTipoMovimiento().equals("Retiro")) {
				cuenta = cuentaRepository.findByNumCuenta(movimientoEntity.getNumCuenta());
				if (cuenta.getSaldoInicial() <= 0) {
					throw new Exception("Saldo no disponible");
				}
				int saldo = cuenta.getSaldoInicial() - movimientoEntity.getValor();
				movimientoEntity.setSaldo(saldo);
			} else if (movimientoEntity.getTipoMovimiento().equals("Deposito")) {
				int saldo = cuenta.getSaldoInicial() + movimientoEntity.getValor();
				movimientoEntity.setSaldo(saldo);
			}
			
			return movimientoRepository.save(movimientoEntity);	
		} catch (Exception e) {
			System.out.println("");
			throw new Exception("Movimiento no creado.");
		}
		
	}
	

	@Override
	public List<MovimientoEntity> consultarMovimientoId(Integer id) throws Exception {
		try {
			return movimientoRepository.findByNumCuenta(id);	
		} catch (Exception e) {
			System.out.println("");
			throw new Exception("Número de movimiento: " + id + ", no fue encontrado.");
		}			  
	}
	
	@Override
	public Iterable<MovimientoEntity> consultarMovimientos() throws Exception {
		return movimientoRepository.findAll();		  
	}
	
	@Override
	public String eliminarMovimiento(Integer id) throws Exception {
		try {
			movimientoRepository.deleteByNumCuenta(id);
			return "Movimiento con id: " + id + " ha sido eliminado.";
		} catch (Exception e) {
			throw new Exception("Movimiento con id: " + id + " no pudo ser eliminado.");
		}
	}


	@Override
	public Map<String, Object> generarReporte(Integer id, LocalDate fechaInicio, LocalDate fechaFin) {
		CuentaEntity cuenta = new CuentaEntity();
		
		cuenta = cuentaRepository.findByNumCuenta(id);
		int saldoAhorros = movimientoRepository.saldoAhorros(id, fechaInicio, fechaFin);
		int saldoCorriente = movimientoRepository.saldoCorriente(id, fechaInicio, fechaFin);
		
		Map<String, Object> reporte = new HashMap<>();
		reporte.put("identidad", id);
        reporte.put("saldoTotal", (saldoAhorros + saldoCorriente));
        reporte.put("totalAhorros", saldoAhorros);
        reporte.put("totalCorriente", saldoCorriente);
		
		return reporte;
	}

}
