package com.mx.oneIt.api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mx.oneIt.api.model.CatDetalle;
import com.mx.oneIt.api.model.CatMaestro;

@Repository
public interface CatDetalleRepository extends JpaRepository<CatDetalle, Long> {
	
	List<CatDetalle> findByIdCatMaestro(CatMaestro catMaestro);
	
	Optional<CatDetalle> findByClave(String clave);
	
}
