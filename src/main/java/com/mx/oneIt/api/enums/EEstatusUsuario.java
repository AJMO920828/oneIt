package com.mx.oneIt.api.enums;

public enum EEstatusUsuario {
	EU_REG("EU_REG"),
	EU_ACT("EU_ACT"),
	EU_BLO("EU_BLO");
	
	private String idEstatus;
	
	private EEstatusUsuario(String idEstatus){
		this.idEstatus = idEstatus;
	}
	
	public String getClvEstatus(){
		return idEstatus;
	}
}
