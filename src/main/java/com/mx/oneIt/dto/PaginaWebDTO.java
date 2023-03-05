package com.mx.oneIt.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaginaWebDTO {

	private String titulo;
	private String subtitulo;
	private String urlImagen;
	private String descripcion;
	private String encabezado;
	private Integer raiting;
	private Long idTipoElemnto;
	private String clvTipoElemento;
	private String descTipoElemento;
}
