package com.mx.oneIt.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mx.oneIt.api.model.CursoImpartido;



@Repository
public interface CursoImpartidoRepository extends JpaRepository<CursoImpartido, Integer>{

}
