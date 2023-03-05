package com.mx.oneIt.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.oneIt.api.dto.*;
import com.mx.oneIt.api.enums.*;
import com.mx.oneIt.api.model.*;
import com.mx.oneIt.api.service.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/Alumno")
public class AlumnoController {
	
	@Autowired
	private PersonaService personaServiceDao;
	@Autowired
	private CursoImpartidoServiceImpl cursoImpartidoService;
	
	@PostMapping("/GuardarAlumno")
	public ResponseEntity<?> GuardarAlumno(@RequestBody PersonaDTO personaDTO){
		try {
			personaDTO.setIndEstatus(EIndEstatus.ACTIVO.getIndEstatus()); 
			if(personaDTO.getIdPersona() != null && personaDTO.getIdUsuario() != null) {
				return ResponseEntity.ok(personaServiceDao.modificarAlumno(personaDTO));
			} else {
				return ResponseEntity.ok(personaServiceDao.guardarAlumno(personaDTO));
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>( "Ocurrió un error al realizar la petición", HttpStatus.BAD_REQUEST);
		}
	}
	@PostMapping("/AgregarAlumnoCurso")
	public ResponseEntity<?> AgregarAlumnoCurso(@RequestBody UsuarioCursoImpartido dto){
		try {
			cursoImpartidoService.agregarAlumnoCurso(dto);
            return ResponseEntity.ok("Usuario Agregado correctamente");
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>( "Ocurrió un error al realizar la petición", HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/ObtenerAlumnos")
	public ResponseEntity<?> ObtenerAlumnos(){
		try {
            return ResponseEntity.ok(personaServiceDao.obtenerAlumnosAll(ERole.ROLE_ALUMNO.name(), EIndEstatus.ACTIVO.getIndEstatus()));
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>( "Ocurrió un error al realizar la petición", HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/ObtenerAlumnosByIdCurso")
	public ResponseEntity<?> ObtenerAlumnosByIdCurso(@RequestBody CursoImpartidoDTO curso){
		try {
            return ResponseEntity.ok(personaServiceDao.obtenerAlumnosByIdCurso(curso.getIdCursoImpartido(),ERole.ROLE_ALUMNO.name(), EIndEstatus.ACTIVO.getIndEstatus()));
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>( "Ocurrió un error al realizar la petición", HttpStatus.BAD_REQUEST);
		}
	}

}
