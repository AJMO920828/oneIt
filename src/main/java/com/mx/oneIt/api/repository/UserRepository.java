package com.mx.oneIt.api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mx.oneIt.api.model.Usuario;

@Repository
public interface UserRepository extends JpaRepository<Usuario, Long> {
	
	Optional<Usuario> findByUsuario(String usuario);
	
	List<Usuario> findByUsuarioAndIndEstatus(String usuario, String indEstatus);

	Boolean existsByUsuario(String usuario);
	
}
