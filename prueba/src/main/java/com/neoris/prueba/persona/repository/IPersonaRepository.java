package com.neoris.prueba.persona.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.neoris.prueba.entity.PersonaEntity;

@Repository
public interface IPersonaRepository extends CrudRepository<PersonaEntity, Integer>{

}
