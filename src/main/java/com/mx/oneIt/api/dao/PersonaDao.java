package com.mx.oneIt.api.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.mx.oneIt.api.dto.*;
import com.mx.oneIt.api.model.Empresa;
import com.mx.oneIt.api.model.Persona;
import com.mx.oneIt.api.repository.*;

@Repository
public class PersonaDao {

	@Autowired
	private PersonaRepository personaRepository;
	@Autowired
	private JdbcTemplate jdbcTemplate;


	
	public boolean existPersonaByEmail(String email) {
		return personaRepository.existsByCorreo(email);
	}
	public PersonaDTO guardarPersona(PersonaDTO personaDto) throws Exception {
		Persona persona = new Persona(personaDto);
		personaRepository.save(persona);
		return new PersonaDTO(personaRepository.findByIdPersona(persona.getIdPersona()).get());
	}
	public PersonaDTO modificarAlumno(PersonaDTO personaDto) throws Exception {
		Persona persona = personaRepository.findByIdPersona(personaDto.getIdPersona()).get();
		persona.setNombre(personaDto.getNombre());
		persona.setPrimerApellido(personaDto.getPrimerApellido());
		persona.setSegundoApellido(personaDto.getSegundoApellido());
		persona.setCelular(personaDto.getCelular());
		persona.setCorreo(personaDto.getCorreo());
		persona.setCorreoInstitucional(personaDto.getCorreoInstitucional());
		persona.setRfc(personaDto.getRfc());
		if(personaDto.getIdEmpresa() != null && personaDto.getIdEmpresa().getIdEmpresa() != null) {
			persona.setIdEmpresa(new Empresa(personaDto.getIdEmpresa().getIdEmpresa()));
		}
		personaRepository.save(persona);
		personaDto = new PersonaDTO(personaRepository.findByIdPersona(persona.getIdPersona()).get());
		return personaDto;
	}
	
	public List<PersonaDTO> obtenerPersonaByClvRolAndIndEstatus(String clvRol,Integer estatus) throws Exception {
		String sql = "select \r\n"
				+ " concat(p.nombre, ' ', p.primer_Apellido, ' ', ifnull(p.segundo_apellido,'')) as  nombreCompleto, \r\n"
		        + "	p.id_persona, p.nombre, p.primer_Apellido, p.segundo_apellido, p.celular, p.correo,\r\n"
		        + "	r.descripcion, u.id_usuario \r\n"
		        + "from\r\n"
		        + "	rol r \r\n"
		        + "	join usuario_rol ur on r.id_rol = ur.id_rol and r.clave_rol = ?\r\n"
		        + "	join usuario u on ur.id_usuario = u.id_usuario \r\n"
		        + "	join persona p on u.id_persona = p.id_persona  and p.ind_estatus = ?";
		@SuppressWarnings("deprecation")
		List<PersonaDTO> personasDto =jdbcTemplate.query(
	        sql, 
	        new Object[] {clvRol, estatus },
	        (rs, rowNum) -> new PersonaDTO(
	        					rs.getLong("id_usuario"),
				        		rs.getInt("id_persona"),
				        		rs.getString("nombre"),
				        		rs.getString("primer_apellido"),
				        		rs.getString("segundo_apellido"),
				        		rs.getString("celular"),
				        		rs.getString("correo"),
				        		rs.getString("nombreCompleto")
				        	)
	    );

		
		return personasDto;
	}
	
	public List<PersonaDTO> obtenerAlumnosAll(String clvRol,Integer estatus) throws Exception {
		String sql = "select \r\n"
		        + "	p.id_persona, p.nombre, p.primer_Apellido, p.segundo_apellido, p.celular, p.correo,\r\n"
		        + "	r.descripcion, u.id_usuario \r\n"
		        + "from\r\n"
		        + "	rol r \r\n"
		        + "	join usuario_rol ur on r.id_rol = ur.id_rol and r.clave_rol = ?\r\n"
		        + "	join usuario u on ur.id_usuario = u.id_usuario \r\n"
		        + "	join persona p on u.id_persona = p.id_persona  and p.ind_estatus = ?";
		@SuppressWarnings("deprecation")
		List<PersonaDTO> personasDto =jdbcTemplate.query(
	        sql, 
	        new Object[] {clvRol, estatus },
	        (rs, rowNum) -> new PersonaDTO(
	        					rs.getLong("id_usuario"),
				        		rs.getInt("id_persona"),
				        		rs.getString("nombre"),
				        		rs.getString("primer_apellido"),
				        		rs.getString("segundo_apellido"),
				        		rs.getString("celular"),
				        		rs.getString("correo"),
				        		null
				        	)
	    );

		
		return personasDto;
	}
	
	public List<PersonaDTO> obtenerAlumnosByIdCurso(Integer idCursoImpartido, String clvRol,Integer estatus) throws Exception {
		String sql = "select \r\n"
		        + "	p.id_persona, p.nombre, p.primer_Apellido, p.segundo_apellido, p.celular, p.correo, \r\n"
		        + "	r.descripcion, u.id_usuario \r\n"
		        + "from \r\n"
		        + "	rol r \r\n"
		        + "	join usuario_rol ur on r.id_rol = ur.id_rol and r.clave_rol = ? \r\n"
		        + "	join usuario u on ur.id_usuario = u.id_usuario \r\n"
		        + "	join persona p on u.id_persona = p.id_persona  and p.ind_estatus = ? \r\n"
		        + " join usuario_curso_impartido uci on u.id_usuario = uci.id_usuario and uci.id_curso_impartido = ?";
		@SuppressWarnings("deprecation")
		List<PersonaDTO> personasDto =jdbcTemplate.query(
	        sql, 
	        new Object[] {clvRol, estatus, idCursoImpartido },
	        (rs, rowNum) -> new PersonaDTO(
	        					rs.getLong("id_usuario"),
				        		rs.getInt("id_persona"),
				        		rs.getString("nombre"),
				        		rs.getString("primer_apellido"),
				        		rs.getString("segundo_apellido"),
				        		rs.getString("celular"),
				        		rs.getString("correo"),
				        		null
				        	)
	    );

		
		return personasDto;
	}
}
