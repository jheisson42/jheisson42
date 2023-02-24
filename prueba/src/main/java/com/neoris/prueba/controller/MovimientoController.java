package com.neoris.prueba.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neoris.prueba.movimiento.service.IMovimientoService;
import com.neoris.prueba.entity.MovimientoEntity;

@CrossOrigin
@RestController
@RequestMapping(value = "movimiento", produces = {MediaType.APPLICATION_JSON_VALUE})
public class MovimientoController {

	@Autowired
	private IMovimientoService movimientoService;


    @PostMapping()
    public ResponseEntity<Object> crearMovimiento(@RequestBody MovimientoEntity movimientoEntity) {
        try {
        	System.out.println();
        	return ResponseEntity.status(HttpStatus.OK).body(movimientoService.crearMovimiento(movimientoEntity));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
    }
    

    @GetMapping("/{idMovimiento}")
    public ResponseEntity<Object> consultarMovimientoId(@PathVariable("idMovimiento") Integer idMovimiento) {
        try {
        	System.out.println();
        	return ResponseEntity.status(HttpStatus.OK).body(movimientoService.consultarMovimientoId(idMovimiento));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
    }
    
    @GetMapping()
    public ResponseEntity<Object> consultarMovimientos() {
        try {
        	System.out.println();
        	return ResponseEntity.status(HttpStatus.OK).body(movimientoService.consultarMovimientos());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
    }
    
    @GetMapping("/reportes/{idMovimiento}")
    public ResponseEntity<Object> reporte(@PathVariable("idMovimiento") Integer idMovimiento, 
    									  @RequestParam("fechaIni")@DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate fechaInicio,
    									  @RequestParam("fechaFin")@DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate fechaFin) {
        try {
        	System.out.println();
        	return ResponseEntity.status(HttpStatus.OK).body(movimientoService.generarReporte(idMovimiento, fechaInicio, fechaFin));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
    }
    

    @DeleteMapping("/{idMovimiento}")
    public ResponseEntity<Object> eliminarMovimiento(@PathVariable("idMovimiento") Integer idMovimiento) {
        try {
        	System.out.println();
        	return ResponseEntity.status(HttpStatus.OK).body(movimientoService.eliminarMovimiento(idMovimiento));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
    }
	
}
