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

import com.neoris.prueba.cuenta.service.ICuentaService;
import com.neoris.prueba.entity.CuentaEntity;

@CrossOrigin
@RestController
@RequestMapping(value = "cuenta", produces = {MediaType.APPLICATION_JSON_VALUE})
public class CuentaController {

	@Autowired
	private ICuentaService cuentaService;


    @PostMapping()
    public ResponseEntity<Object> crearCuenta(@RequestBody CuentaEntity cuentaEntity) {
        try {
        	System.out.println();
        	return ResponseEntity.status(HttpStatus.OK).body(cuentaService.crearCuenta(cuentaEntity));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
    }
    

    @GetMapping("/{idCuenta}")
    public ResponseEntity<Object> consultarCuentaId(@PathVariable("idCuenta") String idCuenta) {
        try {
        	System.out.println();
        	return ResponseEntity.status(HttpStatus.OK).body(cuentaService.consultarCuentaId(idCuenta));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
    }
    
    @GetMapping()
    public ResponseEntity<Object> consultarCuentas() {
        try {
        	System.out.println();
        	return ResponseEntity.status(HttpStatus.OK).body(cuentaService.consultarCuentas());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
    }
    

    @DeleteMapping("/{idCuenta}")
    public ResponseEntity<Object> eliminarCuenta(@PathVariable("idCuenta") String idCuenta) {
        try {
        	System.out.println();
        	return ResponseEntity.status(HttpStatus.OK).body(cuentaService.eliminarCuenta(idCuenta));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
    }
	
}
