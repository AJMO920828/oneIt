package com.mx.oneIt.api.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.mx.oneIt.api.model.Rol;
import com.mx.oneIt.api.model.Usuario;
import com.mx.oneIt.api.model.UsuarioRol;

public interface UsuarioRolRepository  extends JpaRepository<UsuarioRol, Long>{

	List<UsuarioRol> findByIdUsuario(Usuario idUsuario);
	List<UsuarioRol> findByIdRolAndIdUsuario(Rol rol,Usuario usuario);
}
