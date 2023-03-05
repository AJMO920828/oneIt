package com.mx.oneIt.api.enums;

public enum EUsuarioTemp {
	GENERADOR_USUARIO_TEMP("GENERADOR_USUARIO_TEMP");

	@SuppressWarnings("unused")
	private String clv;
	
	private EUsuarioTemp(String clv){
		this.clv = clv;
	}
	
	private static String NUMEROS = "0123456789";
	private static String MAYUSCULAS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static String MINUSCULAS = "abcdefghijklmnopqrstuvwxyz";
	
	public String getUsuarioTemp(){
		String contrasenia = "TEMP_";
		String key = "";
		key = MAYUSCULAS + MINUSCULAS + NUMEROS;
		for (int i = 0; i < 8; i++) {
			contrasenia += (key.charAt((int) (Math.random() * key.length())));
		}
		return contrasenia;
	}
}
