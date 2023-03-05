package com.mx.oneIt.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.mx.oneIt.api.dao.PersonaDao;
import com.mx.oneIt.api.dao.UsuarioDao;
import com.mx.oneIt.api.dto.PersonaDTO;

@Service
public class PersonaServiceImpl implements PersonaService{
	@Autowired
	private PersonaDao personaDao;
	
	@Autowired
	private UsuarioDao usuarioDao;
	
	@Transactional
	public PersonaDTO guardarInstructor (PersonaDTO personaDto) throws Exception{
		personaDto = personaDao.guardarPersona(personaDto);
		usuarioDao.generarUsuarioInstructor(personaDto);
		return personaDto;
	}
	
	@Transactional
	public PersonaDTO modificarAlumno(PersonaDTO personaDto) throws Exception{
					
		personaDto = personaDao.modificarAlumno(personaDto);
		return personaDto;
	}
	
	@Transactional
	public PersonaDTO guardarAlumno (PersonaDTO personaDto) throws Exception{
		personaDto = personaDao.guardarPersona(personaDto);
		usuarioDao.generarUsuarioAlumno(personaDto);
		return personaDto;
	}
	
	@Transactional
	public PersonaDTO guardarPersona (PersonaDTO personaDto) throws Exception{
		personaDto = personaDao.guardarPersona(personaDto);
		return personaDto;
	}
	
	@Transactional
	public List<PersonaDTO> obtenerPersonaByClvRolAndIndEstatus(String clvRol,Integer estatus) throws Exception {
		return personaDao.obtenerPersonaByClvRolAndIndEstatus(clvRol,estatus);
	}
	
	@Transactional
	public List<PersonaDTO> obtenerAlumnosAll(String clvRol,Integer estatus) throws Exception {
		return personaDao.obtenerAlumnosAll(clvRol,estatus);
	}
	
	@Transactional
	public List<PersonaDTO> obtenerAlumnosByIdCurso(Integer idCursoImpartido, String clvRol, Integer estatus) throws Exception {
		return personaDao.obtenerAlumnosByIdCurso(idCursoImpartido,clvRol,estatus);
	}
}
