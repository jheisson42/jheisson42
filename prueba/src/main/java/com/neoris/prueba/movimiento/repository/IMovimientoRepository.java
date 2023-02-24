package com.neoris.prueba.movimiento.repository;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.neoris.prueba.entity.MovimientoEntity;

@Repository
public interface IMovimientoRepository extends CrudRepository<MovimientoEntity, Integer>{
	
	List<MovimientoEntity> findByNumCuenta(Integer id);
	
	@Transactional
	int deleteByNumCuenta(Integer id);
	
	@Transactional
	@Query(value = "SELECT (cuen.saldo_inicial - sum(valor)) saldo " + 
					"FROM cuentas cuen " + 
					"JOIN personas per ON per.identidad = cuen.identidad " + 
					"JOIN movimientos mov ON cuen.num_cuenta = mov.num_cuenta " + 
					"WHERE per.identidad= :id " + 
					"AND cuen.tipo_cuenta = \"Ahorro\" " + 
					"AND mov.fecha  BETWEEN :fechaInicio AND :fechaFin", nativeQuery = true)
	int saldoAhorros(@Param("id") Integer id, 
					 @Param("fechaInicio")LocalDate fechaInicio,
					 @Param("fechaFin") LocalDate fechaFin);
	
	@Transactional
	@Query(value = "SELECT (cuen.saldo_inicial - sum(valor)) saldo " + 
					"FROM cuentas cuen " + 
					"JOIN personas per ON per.identidad = cuen.identidad " + 
					"JOIN movimientos mov ON cuen.num_cuenta = mov.num_cuenta " + 
					"WHERE per.identidad= :id " + 
					"AND cuen.tipo_cuenta = \"Corriente\" " + 
					"AND mov.fecha  BETWEEN :fechaInicio AND :fechaFin", nativeQuery = true)
	int saldoCorriente(@Param("id") Integer id, 
					 @Param("fechaInicio")LocalDate fechaInicio,
					 @Param("fechaFin") LocalDate fechaFin);
}
