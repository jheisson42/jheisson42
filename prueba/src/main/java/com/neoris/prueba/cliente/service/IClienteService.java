package com.neoris.prueba.cliente.service;

import com.neoris.prueba.entity.ClienteEntity;

public interface IClienteService {

	public ClienteEntity crearCliente(ClienteEntity clienteEntity) throws Exception;
	
	public ClienteEntity consultarClienteId(String id) throws Exception;

	public Iterable<ClienteEntity> consultarClientes() throws Exception;

	public String eliminarCliente(String id) throws Exception;

}
