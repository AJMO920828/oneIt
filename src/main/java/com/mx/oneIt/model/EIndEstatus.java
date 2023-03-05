package com.mx.oneIt.model;

public enum EIndEstatus {
	ACTIVO("1"),
	INACTIVO("0");
	
	private String idEstatus;
	
	private EIndEstatus(String idEstatus){
		this.idEstatus = idEstatus;
	}
	
	public String getIndEstatus(){
		return idEstatus;
	}
	
	
}
