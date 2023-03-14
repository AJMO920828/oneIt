package com.mx.oneIt.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "domicilio")
public class Domicilio extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7204961463047396122L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_domicilio")
	private Long idDomicilio;
	
	@Column
	private String calle;
	
	@Column
	private String colonia;
	
	@Column
	private String delegacion;
	
	@Column
	private String estado;
	
	@Column
	private String municipio;
	
	@Column(name = "num_int")
	private String numInt;
	
	@Column(name = "num_ext")
	private String numExt;
	
	@Column
	private Integer cp;
	
	@Column(name = "id_usuario")
	private Long idUsuario;
}
