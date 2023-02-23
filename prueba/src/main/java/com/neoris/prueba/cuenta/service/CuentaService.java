package com.neoris.prueba.cuenta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neoris.prueba.cuenta.repository.ICuentaRepository;
import com.neoris.prueba.entity.CuentaEntity;

@Service
public class CuentaService implements ICuentaService {
	
	@Autowired
	private ICuentaRepository cuentaRepository;  

	@Override
	public CuentaEntity crearCuenta(CuentaEntity cuentaEntity) throws Exception {

		try {
			return cuentaRepository.save(cuentaEntity);	
		} catch (Exception e) {
			System.out.println("");
			throw new Exception("Cuenta no creado.");
		}
		
		/*try {
			CuentaEntity cuenta = this.consultarCuentaId(cuentaEntity.getIdentidad());
			if (cuenta != null) {
				cuentaEntity.setIdcuenta(cuenta.getIdcuenta());
				return cuentaRepository.save(cuentaEntity);
			} else {
				return cuentaRepository.save(cuentaEntity);	
			}
			
				
		} catch (Exception e) {
			System.out.println("");
			throw new Exception("Cuenta no creado.");
		}	*/
	}
	

	@Override
	public CuentaEntity consultarCuentaId(String id) throws Exception {
		try {
			return cuentaRepository.findByNumCuenta(Integer.parseInt(id));	
		} catch (Exception e) {
			System.out.println("");
			throw new Exception("Número de cuenta: " + id + ", no fue encontrado.");
		}			  
	}
	
	@Override
	public Iterable<CuentaEntity> consultarCuentas() throws Exception {
		return cuentaRepository.findAll();		  
	}
	
	@Override
	public String eliminarCuenta(String id) throws Exception {
		try {
			cuentaRepository.deleteByNumCuenta(Integer.parseInt(id));
			return "Cuenta con id: " + id + " ha sido eliminado.";
		} catch (Exception e) {
			throw new Exception("Cuenta con id: " + id + " no pudo ser eliminado.");
		}
	}

}
