package com.neoris.prueba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neoris.prueba.cliente.service.IClienteService;
import com.neoris.prueba.entity.ClienteEntity;

@CrossOrigin
@RestController
@RequestMapping(value = "cliente", produces = {MediaType.APPLICATION_JSON_VALUE})
public class ClienteController {

	@Autowired
	private IClienteService clienteService;


    @PostMapping()
    public ResponseEntity<Object> crearCliente(@RequestBody ClienteEntity clienteEntity) {
        try {
        	System.out.println();
        	return ResponseEntity.status(HttpStatus.OK).body(clienteService.crearCliente(clienteEntity));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
    }
    

    @GetMapping("/{idCliente}")
    public ResponseEntity<Object> consultarClienteId(@PathVariable("idCliente") String idCliente) {
        try {
        	System.out.println();
        	return ResponseEntity.status(HttpStatus.OK).body(clienteService.consultarClienteId(idCliente));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
    }
    
    @GetMapping()
    public ResponseEntity<Object> consultarClientes() {
        try {
        	System.out.println();
        	return ResponseEntity.status(HttpStatus.OK).body(clienteService.consultarClientes());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
    }
    

    @DeleteMapping("/{idCliente}")
    public ResponseEntity<Object> eliminarCliente(@PathVariable("idCliente") String idCliente) {
        try {
        	System.out.println();
        	return ResponseEntity.status(HttpStatus.OK).body(clienteService.eliminarCliente(idCliente));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
    }
	
}
