package com.mx.oneIt.api.enums;

public enum EIndEstatus {
	ACTIVO(1),
	INACTIVO(0);
	
	private Integer idEstatus;
	
	private EIndEstatus(Integer idEstatus){
		this.idEstatus = idEstatus;
	}
	
	public Integer getIndEstatus(){
		return idEstatus;
	}
	
	
}
