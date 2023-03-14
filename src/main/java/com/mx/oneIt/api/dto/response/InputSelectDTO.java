package com.mx.oneIt.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class InputSelectDTO {

	private Integer idOpcion;
	private String descripcion;
	private String clave;
	private Boolean indEstatus;
	
	
	public InputSelectDTO(Integer idOpcion, String descripcion, String clave) {
		super();
		this.idOpcion = idOpcion;
		this.descripcion = descripcion;
		this.clave = clave;
	}

}
