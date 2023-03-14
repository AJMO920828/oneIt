package com.mx.oneIt.api.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.mx.oneIt.api.dto.*;
import com.mx.oneIt.api.dto.response.InputSelectDTO;
import com.mx.oneIt.api.enums.EMaestro;
import com.mx.oneIt.api.model.Persona;
import com.mx.oneIt.api.repository.*;

@Repository
public class PersonaDao {

	@Autowired
	private PersonaRepository personaRepository;
	@Autowired
	private JdbcTemplate jdbcTemplate;

	
	@SuppressWarnings("deprecation")
	public List<InputSelectDTO> obtenerRoles() throws Exception {
		String sql = "SELECT r.id_rol, r.clave, r.descripcion, ind_estatus  from rol r ";
		
		return jdbcTemplate.query(
	        sql, 
	        new Object[] { },
	        (rs, rowNum) -> {
	        	InputSelectDTO dto = new InputSelectDTO();
	        	dto.setIdOpcion(rs.getInt("id_rol"));
	        	dto.setDescripcion(rs.getString("descripcion"));
	        	dto.setClave(rs.getString("clave"));
	        	dto.setIndEstatus(rs.getBoolean("ind_estatus"));
	        	return dto ;
	        });
	}
	
	@SuppressWarnings("deprecation")
	public List<InputSelectDTO> obtenerEstatusUsuario() throws Exception {
		String sql = "SELECT cd.id_cat_detalle, cd.descripcion, cd.clave, cd.ind_estatus \r\n"
				+ "from cat_detalle cd \r\n"
				+ "join cat_maestro cm on cm.id_cat_maestro = cd.id_cat_maestro and cm.clave = ? ";
		
		return jdbcTemplate.query(
	        sql, 
	        new Object[] { EMaestro.EST_US.name()},
	        (rs, rowNum) -> {
	        	InputSelectDTO dto = new InputSelectDTO();
	        	dto.setIdOpcion(rs.getInt("id_cat_detalle"));
	        	dto.setDescripcion(rs.getString("descripcion"));
	        	dto.setClave(rs.getString("clave"));
	        	dto.setIndEstatus(rs.getBoolean("ind_estatus"));
	        	return dto ;
	        });
	}
	

	public UsuarioDTO obtenerUsuario(Long idUsuario) {
		String sql = "SELECT \r\n"
				+ "u.usuario, u.id_usuario,\r\n"
				+ "p.id_persona, p.nombre, p.primer_apellido, p.segundo_apellido, celular, correo, correo_institucional, rfc,\r\n"
				+ "d.id_domicilio, d.calle, d.colonia, d.delegacion, num_int, num_ext, cp\r\n"
				+ "from usuario u\r\n"
				+ "left join persona p on p.id_usuario = u.id_usuario \r\n"
				+ "left join domicilio d on d.id_usuario = u.id_usuario \r\n"
				+ "where u.id_usuario = ?";
		@SuppressWarnings("deprecation")
		List<UsuarioDTO> list =jdbcTemplate.query(
	        sql, 
	        new Object[] { idUsuario },
	        (rs, rowNum) -> {

	        	DomicilioDTO dom = new DomicilioDTO();
	        	dom.setIdDomicilio(rs.getLong("id_domicilio")>0 ?rs.getLong("id_domicilio"): null);
	        	dom.setCalle(rs.getString("calle"));
	        	dom.setColonia(rs.getString("colonia"));
	        	dom.setDelegacion(rs.getString("delegacion"));
	        	dom.setNumExt(rs.getString("num_ext"));
	        	dom.setNumInt(rs.getString("num_int"));
	        	dom.setCp(rs.getInt("cp")>0?rs.getInt("cp"):null);
	        	dom.setIdUsuario(rs.getLong("id_usuario")>0 ?rs.getLong("id_usuario"): null);
	        	
	        	PersonaDTO per = new PersonaDTO();
	        	per.setIdPersona(rs.getLong("id_persona")>0 ?rs.getLong("id_persona"): null);
	        	per.setNombre(rs.getString("nombre"));
	        	per.setPrimerApellido(rs.getString("primer_apellido"));
	        	per.setSegundoApellido(rs.getString("segundo_apellido"));
	        	per.setCelular(rs.getString("celular"));
	        	per.setCorreo(rs.getString("correo"));
	        	per.setCorreoInstitucional(rs.getString("correo_institucional"));
	        	per.setRfc(rs.getString("rfc"));
	        	per.setIdUsuario(rs.getLong("id_usuario")>0 ?rs.getLong("id_usuario"): null);
	        	per.setDomicilio(dom);
	        	
	        	UsuarioDTO dto = new UsuarioDTO();
	        	dto.setUsuario(rs.getString("usuario"));
	        	dto.setIdUsuario(rs.getLong("id_usuario")>0 ?rs.getLong("id_usuario"): null);
	        	dto.setPersona(per);
	        	
	        	return dto;
	        }
	    );
		
		return list.get(0);
	}


	
	public boolean existPersonaByEmail(String email) {
		return personaRepository.existsByCorreo(email);
	}
	public PersonaDTO guardarPersona(PersonaDTO personaDto) throws Exception {
		Persona persona = new Persona(personaDto);
		personaRepository.save(persona);
		personaDto.setIdPersona(persona.getIdPersona());
		return personaDto;
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
		/*if(personaDto.getIdEmpresa() != null && personaDto.getIdEmpresa().getIdEmpresa() != null) {
			persona.setIdEmpresa(new Empresa(personaDto.getIdEmpresa().getIdEmpresa()));
		}*/
		personaRepository.save(persona);
		
		personaDto.setIdPersona(persona.getIdPersona());
		return personaDto;
	}
	
	
	
	
	
	
	public List<PersonaDTO> obtenerAlumnosAll(String clvRol,Integer estatus) throws Exception {
		String sql = "select \r\n"
		        + "	p.id_persona, p.nombre, p.primer_Apellido, p.segundo_apellido, p.celular, p.correo,\r\n"
		        + "	r.descripcion, u.id_usuario \r\n"
		        + "from\r\n"
		        + "	rol r \r\n"
		        + "	join usuario_rol ur on r.id_rol = ur.id_rol and r.clave = ?\r\n"
		        + "	join usuario u on ur.id_usuario = u.id_usuario \r\n"
		        + "	join persona p on u.id_usuario = p.id_usuario  and p.ind_estatus = ?";
		@SuppressWarnings("deprecation")
		List<PersonaDTO> personasDto =jdbcTemplate.query(
	        sql, 
	        new Object[] {clvRol, estatus },
	        (rs, rowNum) -> {
	        	PersonaDTO dto = new PersonaDTO();
	        	dto.setIdUsuario(rs.getLong("id_usuario"));
	        	dto.setIdPersona(rs.getLong("id_persona"));
	        	dto.setNombre(rs.getString("nombre"));
	        	dto.setPrimerApellido(rs.getString("primer_apellido"));
	        	dto.setSegundoApellido(rs.getString("segundo_apellido"));
	        	dto.setCelular(rs.getString("celular"));
	        	dto.setCorreo(rs.getString("correo"));
        		
	        	return dto;
	        }
	    );

		
		return personasDto;
	}
	
	public List<PersonaDTO> obtenerAlumnosByIdCurso(Integer idCursoImpartido, String clvRol,Integer estatus) throws Exception {
		String sql = "select \r\n"
		        + "	p.id_persona, p.nombre, p.primer_Apellido, p.segundo_apellido, p.celular, p.correo, \r\n"
		        + "	r.descripcion, u.id_usuario \r\n"
		        + "from \r\n"
		        + "	rol r \r\n"
		        + "	join usuario_rol ur on r.id_rol = ur.id_rol and r.clave = ? \r\n"
		        + "	join usuario u on ur.id_usuario = u.id_usuario \r\n"
		        + "	join persona p on u.id_usuario = p.id_usuario  and p.ind_estatus = ? \r\n"
		        + " join usuario_curso_impartido uci on u.id_usuario = uci.id_usuario and uci.id_curso_impartido = ?";
		@SuppressWarnings("deprecation")
		List<PersonaDTO> personasDto =jdbcTemplate.query(
	        sql, 
	        new Object[] {clvRol, estatus, idCursoImpartido },
	        (rs, rowNum) -> {
	        	PersonaDTO dto = new PersonaDTO();
	        	dto.setIdUsuario(rs.getLong("id_usuario"));
	        	dto.setIdPersona(rs.getLong("id_persona"));
	        	dto.setNombre(rs.getString("nombre"));
	        	dto.setPrimerApellido(rs.getString("primer_apellido"));
	        	dto.setSegundoApellido(rs.getString("segundo_apellido"));
	        	dto.setCelular(rs.getString("celular"));
	        	dto.setCorreo(rs.getString("correo"));
        		
	        	return dto;
	        }
	    );

		
		return personasDto;
	}
}
