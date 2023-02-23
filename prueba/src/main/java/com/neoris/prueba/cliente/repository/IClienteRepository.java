package com.neoris.prueba.cliente.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.neoris.prueba.entity.ClienteEntity;

@Repository
public interface IClienteRepository extends CrudRepository<ClienteEntity, Integer>{

	ClienteEntity findByIdentidad(String id);

	@Transactional
	int deleteByIdentidad(String id);

}
