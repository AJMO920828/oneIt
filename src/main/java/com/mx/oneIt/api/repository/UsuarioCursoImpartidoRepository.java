package com.mx.oneIt.api.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.oneIt.api.model.CursoImpartido;
import com.mx.oneIt.api.model.Usuario;
import com.mx.oneIt.api.model.UsuarioCursoImpartido;

public interface UsuarioCursoImpartidoRepository  extends JpaRepository<UsuarioCursoImpartido, Integer>{

	List<UsuarioCursoImpartido> findByIdUsuario(Integer usuario);
	List<UsuarioCursoImpartido> findByIdCursoImpartidoAndIdUsuario(CursoImpartido cursoImpartido, Usuario usuario);
}
