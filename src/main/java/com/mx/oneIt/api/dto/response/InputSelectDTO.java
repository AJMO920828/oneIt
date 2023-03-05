package com.mx.oneIt.api.dto.response;

public class InputSelectDTO {

	private Integer idOpcion;
	private String descripcion;
	private String clave;
	private Boolean indEstatus;
	
	public InputSelectDTO() {
		super();
	}
	
	public InputSelectDTO(Integer idOpcion, String descripcion, String clave) {
		super();
		this.idOpcion = idOpcion;
		this.descripcion = descripcion;
		this.clave = clave;
	}

	public InputSelectDTO(Integer idOpcion, String descripcion, String clave, Boolean indEstatus) {
		super();
		this.idOpcion = idOpcion;
		this.descripcion = descripcion;
		this.clave = clave;
		this.indEstatus = indEstatus;
	}

	public Integer getIdOpcion() {
		return idOpcion;
	}
	public void setIdOpcion(Integer idOpcion) {
		this.idOpcion = idOpcion;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public Boolean getIndEstatus() {
		return indEstatus;
	}
	public void setIndEstatus(Boolean indEstatus) {
		this.indEstatus = indEstatus;
	}
	
}
