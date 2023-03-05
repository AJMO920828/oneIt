package com.mx.oneIt.api.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mx.oneIt.api.dao.PersonaDao;
import com.mx.oneIt.api.dao.UsuarioDao;
import com.mx.oneIt.api.dto.PersonaDTO;
import com.mx.oneIt.api.dto.UsuarioDTO;

@Service
public class UsuarioService {

	
	@Autowired
	private UsuarioDao usuarioDao;
	@Autowired
	private PersonaDao personaDao;
	
	/*public static String NUMEROS = "0123456789";

	public static String MAYUSCULAS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	public static String MINUSCULAS = "abcdefghijklmnopqrstuvwxyz";

	public static String ESPECIALES = "ñÑ@$%&#?¡¿!";

	private String generarContrasenia() {
		String key = NUMEROS + MAYUSCULAS + MINUSCULAS + ESPECIALES;

		String contrasenia = "";
		for (int i = 0; i < 10; i++) {
			contrasenia += (key.charAt((int) (Math.random() * key.length())));
		}
		return contrasenia;
	}*/

	
	public Boolean ExisteUsuario(String usuario) throws Exception {
		return usuarioDao.ExisteUsuario(usuario);
	}
	
	public void AgregarAlumno(PersonaDTO persona) {
		if(personaDao.existPersonaByEmail(persona.getCorreo())) {
			
		} else {
			try {
				personaDao.guardarPersona(persona);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void AgregarInstructor() {
		
	}
	
	public List<UsuarioDTO> getUsuarios() {
		return new ArrayList<>();//usuarioDao.getUsuarios();
	}

	public PersonaDTO obtenerUsuario(PersonaDTO dto) throws Exception {
		return new PersonaDTO();//usuarioDao.obtenerUsuario(dto);
	}

	public PersonaDTO guardarUsuario(PersonaDTO dto, Long idUsuario) throws Exception {
		
		return dto;
	}
	
}
