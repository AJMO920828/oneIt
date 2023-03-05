package com.mx.oneIt.model;

public enum EIndEstatusSeg {
	ACTIVO("1"),
	INACTIVO("0");
	
	private String idEstatus;
	
	private EIndEstatusSeg(String idEstatus){
		this.idEstatus = idEstatus;
	}
	
	public String getIndEstatus(){
		return idEstatus;
	}
	
	
}
