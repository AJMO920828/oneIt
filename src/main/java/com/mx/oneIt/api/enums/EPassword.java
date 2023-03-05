package com.mx.oneIt.api.enums;

public enum EPassword {
	GENERADOR_PASSWORD("GENERADOR_PASSWORD"),
	GENERADOR_PASSWORD_NUMERICO("GENERADOR_PASSWORD_NUMERICO"),
	GENERADOR_PASSWORD_MAY_MIN_ESP("GENERADOR_PASSWORD_MAY_MIN_ESP"),
	GENERADOR_PASSWORD_MAY_MIN("GENERADOR_PASSWORD_MAY_MIN");

	private String clv;
	
	private EPassword(String clv){
		this.clv = clv;
	}
	
	private static String NUMEROS = "0123456789";
	private static String MAYUSCULAS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static String MINUSCULAS = "abcdefghijklmnopqrstuvwxyz";
	private static String ESPECIALES = "ñÑ@$%&#?¡¿!";
	
	public String getPassword(){
		String contrasenia = "";
		String key = "";
		if("GENERADOR_PASSWORD".equals(clv)) {
			key = NUMEROS + MAYUSCULAS + MINUSCULAS + ESPECIALES;
		} else if("GENERADOR_PASSWORD_NUMERICO".equals(clv)){
			key = NUMEROS;
		}else if("GENERADOR_PASSWORD_MAY_MIN".equals(clv)){
			key = MAYUSCULAS + MINUSCULAS;
		} else if("GENERADOR_PASSWORD_MAY_MIN_ESP".equals(clv)){
			key = MAYUSCULAS + MINUSCULAS + ESPECIALES;
		}
		for (int i = 0; i < 10; i++) {
			contrasenia += (key.charAt((int) (Math.random() * key.length())));
		}
		return contrasenia;
	}
}
