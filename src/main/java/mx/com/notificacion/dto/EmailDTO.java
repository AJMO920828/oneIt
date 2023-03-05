package mx.com.notificacion.dto;

import java.util.List;

public class EmailDTO {
	
	private String destinatario;
	private String destinatarioCC;
	private String tituloCorreo;
	private String body;
	private List<EmailFileDTO> adjuntos;
	
	public String getDestinatario() {
		return destinatario;
	}
	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}
	public String getDestinatarioCC() {
		return destinatarioCC;
	}
	public void setDestinatarioCC(String destinatarioCC) {
		this.destinatarioCC = destinatarioCC;
	}
	public String getTituloCorreo() {
		return tituloCorreo;
	}
	public void setTituloCorreo(String tituloCorreo) {
		this.tituloCorreo = tituloCorreo;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public List<EmailFileDTO> getAdjuntos() {
		return adjuntos;
	}
	public void setAdjuntos(List<EmailFileDTO> adjuntos) {
		this.adjuntos = adjuntos;
	}
	
}
