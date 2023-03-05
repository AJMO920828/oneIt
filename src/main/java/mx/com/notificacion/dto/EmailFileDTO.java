package mx.com.notificacion.dto;

public class EmailFileDTO {
	
	private String documentoBase64;
	private String nombreAdjunto;
	
	public String getDocumentoBase64() {
		return documentoBase64;
	}
	public void setDocumentoBase64(String documentoBase64) {
		this.documentoBase64 = documentoBase64;
	}
	public String getNombreAdjunto() {
		return nombreAdjunto;
	}
	public void setNombreAdjunto(String nombreAdjunto) {
		this.nombreAdjunto = nombreAdjunto;
	}
		
}
