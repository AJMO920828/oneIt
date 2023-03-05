package com.mx.oneIt.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mx.oneIt.api.enums.EIndEstatus;
import com.mx.oneIt.api.enums.EMaestroId;
import com.mx.oneIt.api.service.CatDetalleService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/catDatosGenerales")
public class CatalogoDatosGeneralesController {

	@Autowired
	private CatDetalleService catDetalleService;

	@GetMapping("/getCatModalidad")
	public ResponseEntity<?> getCatTipoProyecto() {
		try {
			return ResponseEntity.ok(catDetalleService.findByCatDetalle(EMaestroId.MODALIDAD_CURSO.getIdMaestro(),EIndEstatus.ACTIVO.getIndEstatus()));
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>( "Ocurrió un error al realizar la petición", HttpStatus.BAD_REQUEST);
		}
	}
	
	
}

