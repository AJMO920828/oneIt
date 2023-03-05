package com.mx.oneIt.api.enums;

public enum EClaveDetalle {
	EU_REG("EU_REG"),
	EU_ACT("EU_ACT"),
	EU_BLO("EU_BLO"),
	MC_PRE("MC_PRE"),
	MC_LIN("MC_LIN");
	
	private String clv;
	
	private EClaveDetalle(String clv){
		this.clv = clv;
	}
	
	public String getClvDetalle(){
		return clv;
	}
}
