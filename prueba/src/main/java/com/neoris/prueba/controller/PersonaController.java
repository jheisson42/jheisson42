package com.neoris.prueba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neoris.prueba.entity.PersonaEntity;
import com.neoris.prueba.persona.service.IPersonaService;

@CrossOrigin
@RestController
@RequestMapping(value = "persona", produces = {MediaType.APPLICATION_JSON_VALUE})
public class PersonaController {

	@Autowired
	private IPersonaService personaService;


    @PostMapping()
    public ResponseEntity<Object> crearCliente(@RequestBody PersonaEntity personaEntity) {
        try {
        	System.out.println();
        	return ResponseEntity.status(HttpStatus.OK).body(personaService.crearPersona(personaEntity));
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
    }
	
}
