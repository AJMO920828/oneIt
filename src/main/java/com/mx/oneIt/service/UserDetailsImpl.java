package com.mx.oneIt.service;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mx.oneIt.model.User;
import com.mx.oneIt.model.UsuarioRol;

public class UserDetailsImpl implements UserDetails {
	private static final long serialVersionUID = 1L;

	private Long id;

	private String username;
	
	private String clave;

	@JsonIgnore
	private String password;

	private Collection<? extends GrantedAuthority> authorities;

	public UserDetailsImpl(Long id, String username, String password,
			Collection<? extends GrantedAuthority> authorities, String clave) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.authorities = authorities;
		this.clave = clave;
	}

	public static UserDetailsImpl build(User user, List<UsuarioRol> usRol) {
		List<GrantedAuthority> authorities = usRol.stream().map( role -> 
		new SimpleGrantedAuthority(role.getRol().getName().name())
		).collect(Collectors.toList());

		return new UserDetailsImpl(
				user.getIdUsuario(), 
				user.getUsuario(), 
				user.getPassword(), 
				authorities,
				user.getEstatus().getClave());
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}
	
	
	public String getClave() {
		return clave;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		UserDetailsImpl user = (UserDetailsImpl) o;
		return Objects.equals(id, user.id);
	}
}
