package com.neoris.prueba.cliente.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neoris.prueba.cliente.repository.IClienteRepository;
import com.neoris.prueba.entity.ClienteEntity;

@Service
public class ClienteService implements IClienteService {
	
	@Autowired
	private IClienteRepository clienteRepository;  

	@Override
	public ClienteEntity crearCliente(ClienteEntity clienteEntity) throws Exception {
		try {
			ClienteEntity cliente = this.consultarClienteId(clienteEntity.getIdentidad());
			if (cliente != null) {
				clienteEntity.setIdcliente(cliente.getIdcliente());
				return clienteRepository.save(clienteEntity);
			} else {
				return clienteRepository.save(clienteEntity);	
			}
			
				
		} catch (Exception e) {
			System.out.println("");
			throw new Exception("Cliente no creado.");
		}		 
		  
	}
	

	@Override
	public ClienteEntity consultarClienteId(String id) throws Exception {
		try {
			return clienteRepository.findByIdentidad(id);	
		} catch (Exception e) {
			System.out.println("");
			throw new Exception("Cliente con identidad: " + id + ", no fue encontrado.");
		}			  
	}
	
	@Override
	public Iterable<ClienteEntity> consultarClientes() throws Exception {
		return clienteRepository.findAll();		  
	}
	
	@Override
	public String eliminarCliente(String id) throws Exception {
		int res = clienteRepository.deleteByIdentidad(id);
		if (res == 0) {
			return "Cliente con id: " + id + " ha sido eliminado.";
		} else {
			return "Cliente con id: " + id + " no pudo ser eliminado.";
		}
	}
	
}
