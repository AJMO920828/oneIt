package com.mx.oneIt.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.oneIt.model.User;
import com.mx.oneIt.model.UsuarioRol;

public interface UsuarioRolRepository  extends JpaRepository<UsuarioRol, Long>{

	List<UsuarioRol> findByUsuario(User usuario);
	//List<UsuarioRol> findByUsuarioAndIndEstatus(User usuario,String indEstatus);
}
