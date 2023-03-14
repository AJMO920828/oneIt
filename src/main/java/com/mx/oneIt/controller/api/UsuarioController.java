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
import com.mx.oneIt.api.dto.UsuarioDTO;
import com.mx.oneIt.api.dto.request.ObjectRequest;
import com.mx.oneIt.api.service.CatDetalleService;
import com.mx.oneIt.api.service.UsuarioService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/usuario")
public class UsuarioController extends BaseController{

	@Autowired
	UsuarioService usaurioService;
	
	@Autowired
	CatDetalleService catDetalleService;
	
	@GetMapping("/obtenerUsuarios")
	public ResponseEntity<?> obtenerUsuarios() {
		try {
            return ResponseEntity.ok(usaurioService.getUsuarios());
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>( "Ocurrió un error al realizar la petición", HttpStatus.BAD_REQUEST);
		}
	}
	
	
	@PostMapping("/obtenerUsuario")
	public ResponseEntity<?> obtenerUsuario(@RequestBody UsuarioDTO usuarioDto) {
		try {
			usuarioDto = usaurioService.obtenerUsuario(usuarioDto.getIdUsuario());
            return ResponseEntity.ok(usuarioDto);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>( "Ocurrió un error al realizar la petición", HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/gurdarUsuario")
	public ResponseEntity<?> gurdarUsuario(@RequestBody ObjectRequest request) {
		try {
			//usaurioService.guardarUsuario(request.getPersona(), getIdUsuario())
            return ResponseEntity.ok("Guardado");
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>( "Ocurrió un error al realizar la petición", HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/obtenerRoles")
	public ResponseEntity<?> obtenerRoles() {
		try {
            return ResponseEntity.ok(usaurioService.obtenerRoles());
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>( "Ocurrió un error al realizar la petición", HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/obtenerEstatusUsuario")
	public ResponseEntity<?> obtenerEstatusUsuario() {
		try {
            return ResponseEntity.ok(usaurioService.obtenerEstatusUsuario());
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>( "Ocurrió un error al realizar la petición", HttpStatus.BAD_REQUEST);
		}
	}
	
	
}
