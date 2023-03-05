package com.mx.oneIt.api.dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.mx.oneIt.api.dto.*;
import com.mx.oneIt.api.enums.*;
import com.mx.oneIt.api.model.*;
import com.mx.oneIt.api.repository.*;

@Repository
public class UsuarioDao {
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
