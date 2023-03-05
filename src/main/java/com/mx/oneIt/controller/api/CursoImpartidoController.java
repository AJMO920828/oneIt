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
import com.mx.oneIt.api.dto.CursoImpartidoDTO;
import com.mx.oneIt.api.dto.UsuarioDTO;
import com.mx.oneIt.api.enums.EIndEstatus;
import com.mx.oneIt.api.service.CursoImpartidoServiceImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/CursoImpartido")
public class CursoImpartidoController extends BaseController{
	@Autowired
	private CursoImpartidoServiceImpl cursoImpartidoService;

	@PostMapping("/GuardarCurso")
	public ResponseEntity<?> GuardarCurso(@RequestBody CursoImpartidoDTO dto){
		try {
			dto.setIndEstatus(EIndEstatus.ACTIVO.getIndEstatus()); 
			
			dto.setUsuarioAlta(new UsuarioDTO(getIdUsuario()));
            return ResponseEntity.ok(cursoImpartidoService.guardarCurso(dto));
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>( "Ocurrió un error al realizar la petición", HttpStatus.BAD_REQUEST);
		}
	}
	
	
	
	@PostMapping("/ObtenerCursoImpartido")
	public ResponseEntity<?> ObtenerCursoImpartido(@RequestBody CursoImpartidoDTO dto){
		try {
            return ResponseEntity.ok(cursoImpartidoService.ObtenerCursoImpartidoById(dto.getIdCursoImpartido()));
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>( "Ocurrió un error al realizar la petición", HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/ObtenerCursosImpartidos")
	public ResponseEntity<?> ObtenerCursosImpartidos(){
		try {
            return ResponseEntity.ok(cursoImpartidoService.obtenerCursososImpartidos());
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>( "Ocurrió un error al realizar la petición", HttpStatus.BAD_REQUEST);
		}
	}
	
	
	
	@PostMapping("/cargarCurso")
	public ResponseEntity<?> cargarCurso(@RequestBody CursoImpartidoDTO curso){
		try {
            return ResponseEntity.ok(cursoImpartidoService.obtenerCursoById(curso.getIdCurso()));
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>( "Ocurrió un error al realizar la petición", HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("/obtenerCatalogoCursos")
	public ResponseEntity<?> obtenerCatalogoCursos(){
		try {
            return ResponseEntity.ok(cursoImpartidoService.obterCursos());
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>( "Ocurrió un error al realizar la petición", HttpStatus.BAD_REQUEST);
		}
	}
	
}
