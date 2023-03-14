package com.mx.oneIt.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.mx.oneIt.api.dao.PersonaDao;
import com.mx.oneIt.api.dao.UsuarioDao;
import com.mx.oneIt.api.dto.DomicilioDTO;
import com.mx.oneIt.api.dto.PersonaDTO;
import com.mx.oneIt.api.dto.UsuarioDTO;
import com.mx.oneIt.api.dto.response.InputSelectDTO;
import com.mx.oneIt.api.model.Domicilio;
import com.mx.oneIt.api.model.Persona;
import com.mx.oneIt.api.model.Usuario;
import com.mx.oneIt.api.repository.DomicilioRepository;
import com.mx.oneIt.api.repository.PersonaRepository;
import com.mx.oneIt.api.repository.UsuarioRepository;

@Service
public class UsuarioService {

	
	@Autowired
	private UsuarioDao usuarioDao;
	@Autowired
	private PersonaDao personaDao;
	@Autowired
	private DomicilioRepository domicilioRepository;
	@Autowired
	private PersonaRepository personaRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	PasswordEncoder encoder;
	
	public static String NUMEROS = "0123456789";

	public static String MAYUSCULAS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	public static String MINUSCULAS = "abcdefghijklmnopqrstuvwxyz";

	public static String ESPECIALES = "ñÑ@$%&#?¡¿!";

	@SuppressWarnings("unused")
	private String generarContrasenia() {
		String key = NUMEROS + MAYUSCULAS + MINUSCULAS + ESPECIALES;
		String contrasenia = "";
		for (int i = 0; i < 10; i++) {
			contrasenia += (key.charAt((int) (Math.random() * key.length())));
		}
		return contrasenia;
	}

	
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
		return usuarioDao.getUsuarios();
	}

	public UsuarioDTO obtenerUsuario(Long idUsuario) throws Exception {
		return personaDao.obtenerUsuario(idUsuario);
	}
	
	public List<InputSelectDTO> obtenerRoles() throws Exception {
		return personaDao.obtenerRoles();
	}
	public List<InputSelectDTO> obtenerEstatusUsuario() throws Exception {
		return personaDao.obtenerEstatusUsuario();
	}
	

	public UsuarioDTO cambiarPassword(UsuarioDTO dto) throws Exception {
		Usuario entity = usuarioRepository.findById(dto.getIdUsuario()).get();
		entity.setPassword(encoder.encode(dto.getPassword()));
		usuarioRepository.save(entity);
		return dto;
	}
	public PersonaDTO guardarPersona(PersonaDTO dto) throws Exception {
		Persona p =  new Persona();
		Domicilio d = new Domicilio();
		if(dto.getIdPersona()!= null) {
			p = personaRepository.findById(dto.getIdPersona()).get();
			DomicilioDTO dtoD = new DomicilioDTO();
			if(dto.getDomicilio() != null && 
					dto.getDomicilio().getIdDomicilio() != null) {
				dtoD = dto.getDomicilio();
				d = domicilioRepository.findById(dto.getDomicilio().getIdDomicilio()).get();
				d.setCalle(dtoD.getCalle());
				d.setNumExt(dtoD.getNumExt());
				d.setNumInt(dtoD.getNumInt());
				d.setColonia(dtoD.getColonia());
				d.setCp(dtoD.getCp());
				d.setMunicipio(dtoD.getMunicipio());
				d.setEstado(dtoD.getEstado());
				d.setIdUsuario(dto.getIdUsuario());
				domicilioRepository.save(d);
				dto.getDomicilio().setIdDomicilio(d.getIdDomicilio());
			}
			
		}
		
		
		p.setNombre(dto.getNombre());
		p.setPrimerApellido(dto.getPrimerApellido());
		p.setSegundoApellido(dto.getSegundoApellido());
		p.setCelular(dto.getCelular());
		p.setCorreo(dto.getCorreo());
		p.setCorreoInstitucional(dto.getCorreoInstitucional());
		p.setRfc(dto.getRfc());
		p.setIdUsuario(dto.getIdUsuario());
		
		personaRepository.save(p);
		dto.setIdPersona(p.getIdPersona());
		return dto;
	}
	
}
