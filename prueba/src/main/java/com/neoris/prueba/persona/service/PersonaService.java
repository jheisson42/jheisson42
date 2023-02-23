package com.neoris.prueba.persona.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neoris.prueba.entity.PersonaEntity;
import com.neoris.prueba.persona.repository.IPersonaRepository;

@Service
public class PersonaService implements IPersonaService {
	
	@Autowired
	private IPersonaRepository personaRepository;  

	@Override
	public PersonaEntity crearPersona(PersonaEntity personaEntity) {
		try {
			personaRepository.save(personaEntity);	
		} catch (Exception e) {
			System.out.println("");
		}
		 
		 
		 return null;
	}

}
