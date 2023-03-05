package com.mx.oneIt.model;

import javax.persistence.*;

@Entity
@Table(name = "rol")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idRol;

	@Enumerated(EnumType.STRING)
	@Column(name = "clave" , length = 20)
	private ERole name;

	public Role() {

	}

	public Role(ERole name) {
		this.name = name;
	}

	public Integer getId() {
		return idRol;
	}

	public void setId(Integer idRol) {
		this.idRol = idRol;
	}

	public ERole getName() {
		return name;
	}

	public void setName(ERole name) {
		this.name = name;
	}
}