package com.mx.oneIt.api.enums;

public enum EMaestroId {
	ESTATUS_USUARIO(1),
	MODALIDAD_CURSO(2);
	
	private Integer id;
	
	private EMaestroId(Integer id){
		this.id = id;
	}
	
	public Integer getIdMaestro(){
		return id;
	}
}
