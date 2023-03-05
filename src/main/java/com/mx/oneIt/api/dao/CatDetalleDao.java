package com.mx.oneIt.api.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mx.oneIt.api.dto.*;

@Repository
public class CatDetalleDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	
	
	public List<CatDetalleDTO> findByCatDetalle(Integer idCatMaestro, Integer indEstatus){
		@SuppressWarnings("deprecation")
		List<CatDetalleDTO> cat =jdbcTemplate.query(
	        "select id_cat_detalle, clave , descripcion from cat_detalle cd where id_cat_maestro = ? and ind_estatus = ?", new Object[] { idCatMaestro,  indEstatus},
	        (rs, rowNum) ->{
	        	CatDetalleDTO catalogo = new CatDetalleDTO();
	        	catalogo.setIdCatDetalle(rs.getInt("id_cat_detalle"));
	        	catalogo.setDescripcion(rs.getString("descripcion"));
	        	catalogo.setClave(rs.getString("clave"));
	        	return catalogo;
	        });
		
		return cat;
	}
	
	
}
