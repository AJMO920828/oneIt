package com.mx.oneIt.api.service;

import java.util.List;

import com.mx.oneIt.api.dto.PersonaDTO;

public interface PersonaService {
	
	PersonaDTO guardarInstructor(PersonaDTO personaDto) throws Exception;
	PersonaDTO guardarAlumno(PersonaDTO personaDto) throws Exception;
	PersonaDTO modificarAlumno(PersonaDTO personaDto) throws Exception;
	
	List<PersonaDTO> obtenerPersonaByClvRolAndIndEstatus(String clvRol,Integer estatus) throws Exception;
	
	List<PersonaDTO> obtenerAlumnosAll(String clvRol,Integer estatus) throws Exception;
	List<PersonaDTO> obtenerAlumnosByIdCurso(Integer idCursoImpartido, String clvRol, Integer estatus) throws Exception;
} 
