package com.mx.oneIt.controller;


import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.oneIt.api.repository.RoleRepository;
import com.mx.oneIt.api.repository.UserRepository;
import com.mx.oneIt.controller.api.BaseController;
import com.mx.oneIt.dto.JwtResponse;
import com.mx.oneIt.dto.LoginRequest;
import com.mx.oneIt.jwt.JwtUtils;
import com.mx.oneIt.service.UserDetailsSegImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/principal")
public class PrincipalController extends BaseController {
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;
	
	@Value("${app.jwtExpirationMs}")
	private String jwtExpirationMs;
	
	@Value("${servicio.correo}")
	private String urlServicioCorreo;
	
	@GetMapping("/hello")
	public String Hello() {
		return "Servicio Activo";
	}
	
	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
		String password = encoder.encode(loginRequest.getPassword());
		System.out.println(password);
		
		return ResponseEntity.ok(password);
	}
}
