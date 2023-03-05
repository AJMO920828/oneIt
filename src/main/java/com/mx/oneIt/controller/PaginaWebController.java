package com.mx.oneIt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.oneIt.dao.CursoImpartidoDao;
import com.mx.oneIt.model.ParametersWeb;

import lombok.extern.slf4j.Slf4j;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/web")
@Slf4j
public class PaginaWebController extends BaseController {
	@Autowired
	private CursoImpartidoDao cursoImpartidoDao;
	
	@GetMapping("/obtenerCarruselPrincipal")
	public ResponseEntity<?> obtenerCarruselPrincipal() {
		try {
			return ResponseEntity.ok(cursoImpartidoDao.obtenerCarruselPrincipal(ParametersWeb.TIP_ELEM_PAG_WEB_CP.name()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error(e.getMessage());
			return notFoundError(e.getMessage());
		}
	}
	@GetMapping("/obtenerCarruselProxCursos")
	public ResponseEntity<?> obtenerCarruselProxCursos() {
		try {
			return ResponseEntity.ok(cursoImpartidoDao.obtenerCarruselPrincipal(ParametersWeb.TIP_ELEM_PAG_WEB_PC.name()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error(e.getMessage());
			return notFoundError(e.getMessage());
		}
	}
	@GetMapping("/obtenerCarruselCalendario")
	public ResponseEntity<?> obtenerCarruselCalendario() {
		try {
			return ResponseEntity.ok(cursoImpartidoDao.obtenerCarruselPrincipal(ParametersWeb.TIP_ELEM_PAG_WEB_CC.name()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error(e.getMessage());
			return notFoundError(e.getMessage());
		}
	}
	
	@GetMapping("/obtenerClientes")
	public ResponseEntity<?> obtenerClientes() {
		try {
			return ResponseEntity.ok(cursoImpartidoDao.obtenerCarruselPrincipalRandom(ParametersWeb.TIP_ELEM_PAG_WEB_CLI.name(),3));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error(e.getMessage());
			return notFoundError(e.getMessage());
		}
	}

}
