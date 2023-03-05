package com.mx.oneIt.dto;

import java.util.List;

public class JwtResponse {
	private String token;
	private String type = "Bearer";
	private Long id;
	private String username;
	private String claveEstatusUsuario;
	private List<String> roles;
	private String timeToken;

	public JwtResponse(String accessToken, Long id, String username, List<String> roles, String claveEstatusUsuario, String timeToken) {
		this.token = accessToken;
		this.id = id;
		this.username = username;
		this.roles = roles;
		this.claveEstatusUsuario = claveEstatusUsuario;
		this.timeToken = timeToken;
	}

	public String getAccessToken() {
		return token;
	}

	public void setAccessToken(String accessToken) {
		this.token = accessToken;
	}

	public String getTokenType() {
		return type;
	}

	public void setTokenType(String tokenType) {
		this.type = tokenType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<String> getRoles() {
		return roles;
	}

	public String getClaveEstatusUsuario() {
		return claveEstatusUsuario;
	}

	public void setClaveEstatusUsuario(String claveEstatusUsuario) {
		this.claveEstatusUsuario = claveEstatusUsuario;
	}

	public String getTimeToken() {
		return timeToken;
	}

	public void setTimeToken(String timeToken) {
		this.timeToken = timeToken;
	}
	
	
}
