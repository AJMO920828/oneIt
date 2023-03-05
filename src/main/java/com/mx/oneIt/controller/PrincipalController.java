package com.mx.oneIt.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/principal")
public class PrincipalController extends BaseController {
	
	
	@GetMapping("/hello")
	public String Hello() {
		return "Servicio Activo";
	}
}
