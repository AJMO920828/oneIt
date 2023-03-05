package com.mx.oneIt.controller.api;


import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import mx.com.notificacion.dto.EmailDTO;
import mx.com.notificacion.dto.EmailResponseDTO;

@RestController
@RequestMapping(value = "/api/email")
public class MailController {

	
	org.slf4j.Logger LOG = LoggerFactory.getLogger(MailController.class);
	
	@Value("${servicio.correo}")
	private String urlServicioCorreo;
	
	@RequestMapping(value = "/enviarCorreoTest")
	@ResponseBody
	public EmailResponseDTO enviarCorreo(@RequestParam String correo) {
		EmailDTO emailDTO = new EmailDTO();
		emailDTO.setDestinatario(correo);
		emailDTO.setBody("<h1>Ejemplo de correo de prueba<h1>");
		emailDTO.setTituloCorreo("Correo de prueba ");
		
		
		RestTemplate rs = new RestTemplate();

		EmailResponseDTO response = rs.postForObject(urlServicioCorreo + "/enviarCorreo", emailDTO,  EmailResponseDTO.class);
		
		return response;
	}
	

  
}
