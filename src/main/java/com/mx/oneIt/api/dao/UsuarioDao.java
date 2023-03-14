package com.mx.oneIt.api.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.mx.oneIt.api.dto.*;
import com.mx.oneIt.api.enums.*;
import com.mx.oneIt.api.model.*;
import com.mx.oneIt.api.repository.*;

@Repository
public class UsuarioDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private UsuarioRolRepository usuarioRolRepository;
	@Autowired
	private CatDetalleRepository catDetalleRepository;

	@SuppressWarnings("unused")
	public Boolean ExisteUsuario(String usuario) throws Exception {
		return userRepository.existsByUsuario(usuario);
	}
	
	@SuppressWarnings("deprecation")
	public List<UsuarioDTO> getUsuarios(){
		String sql = "SELECT \r\n"
				+ "u.usuario, u.id_usuario,\r\n"
				+ "p.id_persona, p.nombre, p.primer_apellido, p.segundo_apellido, celular, correo, correo_institucional, rfc,\r\n"
				+ "d.id_domicilio, d.calle, d.colonia, d.delegacion, num_int, num_ext, cp,\r\n"
				+ "cd.descripcion \r\n"
				+ "from usuario u\r\n"
				+ "join cat_detalle cd on cd.id_cat_detalle = u.id_estatus \r\n"
				+ "left join persona p on p.id_usuario = u.id_usuario \r\n"
				+ "left join domicilio d on d.id_usuario = u.id_usuario ";
		return jdbcTemplate.query(
	        sql, 
	        new Object[] { },
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
	        	per.setNombreCompleto(rs.getString("nombre")+" "+rs.getString("primer_apellido"));
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
	        	dto.setDescEstatus(rs.getString("descripcion"));
	        	
	        	String subQuery = " SELECT r.descripcion  from usuario_rol ur \r\n"
	        			+ " join rol r on ur.id_rol = r.id_rol  and r.ind_estatus = 1 and id_usuario = ? ";
	        	List<String> rolesList = jdbcTemplate.query(
	        			subQuery, 
	        	        new Object[] {dto.getIdUsuario() },
	        	        (sub_rs, sub_rowNum) -> {return sub_rs.getString("descripcion");});
	        	String roles = "";
	        	for (String string : rolesList) {
	        		roles = roles +" "+ string + ",";
				}
	        	dto.setRoles(roles);
	        	return dto;
	        }
	    );
	}
	
	@SuppressWarnings("unused")
	public UsuarioDTO generarUsuarioInstructor(PersonaDTO personaDto) {
		Usuario usuario = new Usuario();
		
		CatDetalle estatus = catDetalleRepository.findByClave(EClaveDetalle.EU_REG.getClvDetalle()).get();
		usuario.setEstatus(estatus);
		usuario.setPassword(EPassword.GENERADOR_PASSWORD.getPassword());
		usuario.setUsuario("INS_"+EUsuarioTemp.GENERADOR_USUARIO_TEMP.getUsuarioTemp());
		usuario.setIndEstatus(EIndEstatus.ACTIVO.getIndEstatus());
		usuario.setUsuarioRols(new ArrayList<>());
	
		usuarioRepository.save(usuario);
		
		UsuarioRol usuarioRol = new UsuarioRol();
		usuarioRol.setIdRol(roleRepository.findByClaveRol(ERole.ROLE_INSTRUCTOR.name()).get());
		usuarioRol.setIdUsuario(usuario);
		
		
		usuarioRolRepository.save(usuarioRol);
		UsuarioDTO usuarioDto = new UsuarioDTO();
		return usuarioDto;
	}
	
	
	
	@SuppressWarnings("unused")
	public UsuarioDTO generarUsuarioAlumno(PersonaDTO personaDto) {
		Usuario usuario = new Usuario();
		CatDetalle estatus = catDetalleRepository.findByClave(EClaveDetalle.EU_REG.getClvDetalle()).get();
		usuario.setEstatus(estatus);
		usuario.setPassword(EPassword.GENERADOR_PASSWORD.getPassword());
		usuario.setUsuario("A_"+EUsuarioTemp.GENERADOR_USUARIO_TEMP.getUsuarioTemp());
		usuario.setIndEstatus(EIndEstatus.ACTIVO.getIndEstatus());
		usuario.setUsuarioRols(new ArrayList<>());
		
		usuarioRepository.save(usuario);
		
		UsuarioRol usuarioRol = new UsuarioRol();
		usuarioRol.setIdRol(roleRepository.findByClaveRol(ERole.ROLE_ALUMNO.name()).get());
		usuarioRol.setIdUsuario(usuario);
		
		
		usuarioRolRepository.save(usuarioRol);
		UsuarioDTO usuarioDto = new UsuarioDTO();
		return usuarioDto;
	}

	
}
