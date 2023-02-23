package com.neoris.prueba.movimiento.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.neoris.prueba.entity.MovimientoEntity;

@Repository
public interface IMovimientoRepository extends CrudRepository<MovimientoEntity, Integer>{
	
	List<MovimientoEntity> findByNumCuenta(Integer id);
	
	@Transactional
	int deleteByNumCuenta(Integer id);
}
