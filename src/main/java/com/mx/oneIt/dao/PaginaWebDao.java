package com.mx.oneIt.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.mx.oneIt.dto.PaginaWebDTO;

@Repository
public class PaginaWebDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@SuppressWarnings("deprecation")
	public List<PaginaWebDTO> obtenerCarruselPrincipal(String tipoElemento) throws Exception {
		String sql ="SELECT \r\n"
				+ "pw.titulo, \r\n"
				+ "pw.subtitulo, \r\n"
				+ "pw.encabezado, \r\n"
				+ "pw.descripcion, \r\n"
				+ "pw.raiting, \r\n"
				+ "pw.url_imagen, \r\n"
				+ "pw.id_tipo_elemento,\r\n"
				+ "cd.descripcion descTipoElemento,\r\n"
				+ "cd.clave clvTipoElemento\r\n"
				+ "FROM pagina_web pw \r\n"
				+ "join cat_detalle cd on pw.id_tipo_elemento = cd.id_cat_detalle \r\n"
				+ "where cd.clave = ?";
				List<PaginaWebDTO> proyectos = new ArrayList<PaginaWebDTO>();
				proyectos =jdbcTemplate.query(sql, new Object[] { tipoElemento },(rs, rowNum) ->
				{
					PaginaWebDTO dto = new PaginaWebDTO();
					dto.setTitulo(rs.getString("titulo"));
					dto.setSubtitulo(rs.getString("subtitulo"));
					dto.setEncabezado(rs.getString("encabezado"));
					dto.setDescripcion(rs.getString("descripcion"));
					dto.setRaiting(rs.getInt("raiting"));
					dto.setUrlImagen(rs.getString("url_imagen"));
					dto.setIdTipoElemnto(rs.getLong("id_tipo_elemento"));
					dto.setDescTipoElemento(rs.getString("descTipoElemento"));
					dto.setClvTipoElemento(rs.getString("clvTipoElemento"));
					
					return dto;
			    });
		return proyectos;
	}
	
	@SuppressWarnings("deprecation")
	public List<PaginaWebDTO> obtenerCarruselPrincipalRandom(String tipoElemento, int top) throws Exception {
		String sql ="SELECT \r\n"
				+ "top "+top+" \r\n"
				+ "pw.titulo, \r\n"
				+ "pw.subtitulo, \r\n"
				+ "pw.encabezado, \r\n"
				+ "pw.descripcion, \r\n"
				+ "pw.raiting, \r\n"
				+ "pw.url_imagen, \r\n"
				+ "pw.id_tipo_elemento,\r\n"
				+ "cd.descripcion descTipoElemento,\r\n"
				+ "cd.clave clvTipoElemento\r\n"
				+ "FROM pagina_web pw \r\n"
				+ "join cat_detalle cd on pw.id_tipo_elemento = cd.id_cat_detalle \r\n"
				+ "where cd.clave = ? \r\n"
				+ "ORDER BY NEWID() ";
				List<PaginaWebDTO> proyectos = new ArrayList<PaginaWebDTO>();
				proyectos =jdbcTemplate.query(sql, new Object[] { tipoElemento },(rs, rowNum) ->
				{
					PaginaWebDTO dto = new PaginaWebDTO();
					dto.setTitulo(rs.getString("titulo"));
					dto.setSubtitulo(rs.getString("subtitulo"));
					dto.setEncabezado(rs.getString("encabezado"));
					dto.setDescripcion(rs.getString("descripcion"));
					dto.setRaiting(rs.getInt("raiting"));
					dto.setUrlImagen(rs.getString("url_imagen"));
					dto.setIdTipoElemnto(rs.getLong("id_tipo_elemento"));
					dto.setDescTipoElemento(rs.getString("descTipoElemento"));
					dto.setClvTipoElemento(rs.getString("clvTipoElemento"));
					
					return dto;
			    });
		return proyectos;
	}
	
	
}
