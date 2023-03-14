package com.mx.oneIt.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.oneIt.api.dto.UsuarioDTO;
import com.mx.oneIt.api.service.UsuarioService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/persona")
public class PersonaController extends BaseController{

	@Autowired
	private UsuarioService usaurioService;
	
	@PostMapping("/obtenerPersona")
	public ResponseEntity<?> obtenerPersona(@RequestBody UsuarioDTO usuario) {
		try {
            return ResponseEntity.ok(usaurioService.obtenerUsuario(usuario.getIdUsuario()));
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>( "Ocurrió un error al realizar la petición", HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/guardarPersona")
	public ResponseEntity<?> guardarPersona(@RequestBody UsuarioDTO usuario) {
		try {
            return ResponseEntity.ok(usaurioService.guardarPersona(usuario.getPersona()));
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>( "Ocurrió un error al realizar la petición", HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/cambiarPassword")
	public ResponseEntity<?> cambiarPassword(@RequestBody UsuarioDTO usuario) {
		try {
            return ResponseEntity.ok(usaurioService.cambiarPassword(usuario));
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>( "Ocurrió un error al realizar la petición", HttpStatus.BAD_REQUEST);
		}
	}

}
