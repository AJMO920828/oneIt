package com.mx.oneIt.api.model;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_usuario")
	private Long idUsuario;

	private String usuario;
	
	private String password;
	
	@ManyToOne
	@JoinColumn(name="id_estatus")
	private CatDetalle estatus;

	@Column(name="ind_estatus")
	private Integer indEstatus;
	
	@OneToMany(mappedBy="idUsuario")
	private List<UsuarioRol> usuarioRols;


	public Usuario() {
	}
	

	public Usuario(Long idUsuario) {
		super();
		this.idUsuario = idUsuario;
	}
	
}