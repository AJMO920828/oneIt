package com.mx.oneIt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mx.oneIt.api.repository.RoleRepository;
import com.mx.oneIt.api.repository.UserRepository;
import com.mx.oneIt.controller.api.BaseController;
import com.mx.oneIt.dto.LoginRequest;
import com.mx.oneIt.jwt.JwtUtils;

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
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
		String password = encoder.encode(loginRequest.getPassword());
		System.out.println(password);
		
		return ResponseEntity.ok(password);
	}
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public ResponseEntity<?> authenticateUserget(@RequestBody LoginRequest loginRequest) {
		String password = encoder.encode(loginRequest.getPassword());
		System.out.println(password);
		
		return ResponseEntity.ok(password);
	}
}
