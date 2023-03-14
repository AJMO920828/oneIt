package com.mx.oneIt.api.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DomicilioDTO {
	
	private Long idDomicilio;
	private String calle;
	private String colonia;
	private String delegacion;
	private String numInt;
	private String numExt;
	private String municipio;
	private String estado;
	private Integer cp;
	private Long idUsuario;

}
