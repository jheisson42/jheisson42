package com.neoris.prueba.cuenta.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.neoris.prueba.entity.CuentaEntity;

@Repository
public interface ICuentaRepository extends CrudRepository<CuentaEntity, Integer>{
	
	CuentaEntity findByNumCuenta(Integer id);
	
	@Transactional
	int deleteByNumCuenta(Integer id);
}
