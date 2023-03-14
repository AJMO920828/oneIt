package com.mx.oneIt.api.repository;


import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mx.oneIt.api.model.Persona;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long>{
	
	Boolean existsByCorreo(String correo);
	Optional<Persona> findByIdPersona(Long idPersona);
	
	
	

}
