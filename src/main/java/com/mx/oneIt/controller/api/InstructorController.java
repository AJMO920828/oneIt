package com.mx.oneIt.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mx.oneIt.api.dto.PersonaDTO;
import com.mx.oneIt.api.enums.EIndEstatus;
import com.mx.oneIt.api.service.PersonaService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/Instructor")
public class InstructorController {

	@Autowired
	private PersonaService personaServiceDao;
	
	@PostMapping("/GuardarInstructor")
	public ResponseEntity<?> GuardarInstructor(@RequestBody PersonaDTO personaDTO){
		try {
			personaDTO.setIndEstatus(EIndEstatus.ACTIVO.getIndEstatus()); 
            return ResponseEntity.ok(personaServiceDao.guardarInstructor(personaDTO));
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>( "Ocurrió un error al realizar la petición", HttpStatus.BAD_REQUEST);
		}
	}
	
}
