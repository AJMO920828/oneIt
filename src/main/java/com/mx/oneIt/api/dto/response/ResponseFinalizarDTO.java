package com.mx.oneIt.api.dto.response;

public class ResponseFinalizarDTO {

	private Boolean contieneErrores;
	private String mensajeError;
		
	public Boolean getContieneErrores() {
		return contieneErrores;
	}
	
	public void setContieneErrores(Boolean contieneErrores) {
		this.contieneErrores = contieneErrores;
	}
	
	public String getMensajeError() {
		return mensajeError;
	}
	
	public void setMensajeError(String mensajeError) {
		this.mensajeError = mensajeError;
	}
	
}