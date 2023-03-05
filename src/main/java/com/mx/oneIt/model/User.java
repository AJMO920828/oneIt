package com.mx.oneIt.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "usuario")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private Long idUsuario;

	private String usuario;

	private String password;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "usuario_rol", joinColumns = @JoinColumn(name = "id_usuario"), inverseJoinColumns = @JoinColumn(name = "id_rol"))
	private Set<Role> roles = new HashSet<>();
	
	@ManyToOne
	@JoinColumn(name="id_estatus")
	private CatDetalle estatus;
	
	@Column(name="ind_estatus")
	private String indEstatus;

	public User() {
	}

	public User(String usuario, String password, String estatus) {
		this.usuario = usuario;
		this.password = password;
		this.indEstatus = estatus;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public String getIndEstatus() {
		return indEstatus;
	}

	public void setIndEstatus(String indEstatus) {
		this.indEstatus = indEstatus;
	}

	public CatDetalle getEstatus() {
		return estatus;
	}

	public void setEstatus(CatDetalle estatus) {
		this.estatus = estatus;
	}
	
	
}
