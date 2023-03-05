package com.mx.oneIt.api.enums;

public enum EDefinicionDocumento {
	PDF_ASISTENCIA(1L),
	COMP_PAG_XML(2L);
	
	
	private Long idDefinicionDocumento;
	
	private EDefinicionDocumento(Long  idDefinicionDocumento){
		this.idDefinicionDocumento = idDefinicionDocumento;
	}
	
	public Long getIdDefinicionDocumento(){
		return idDefinicionDocumento;
	}
	
}
