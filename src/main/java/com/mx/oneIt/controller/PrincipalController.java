package com.mx.oneIt.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.oneIt.controller.api.BaseController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/principal")
public class PrincipalController extends BaseController {
	
	
	@Value("${servicio.correo}")
	private String urlServicioCorreo;
	
	@GetMapping("/hello")
	public String Hello() {
		return "Servicio Activo";
	}
}
