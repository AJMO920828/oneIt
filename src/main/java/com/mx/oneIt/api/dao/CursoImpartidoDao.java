package com.mx.oneIt.api.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.mx.oneIt.api.dto.*;
import com.mx.oneIt.api.model.CursoImpartido;
import com.mx.oneIt.api.model.UsuarioCursoImpartido;
import com.mx.oneIt.api.repository.*;

@Repository
public class CursoImpartidoDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private CursoImpartidoRepository cursoImpartidoRepository;
	@Autowired
	private UsuarioCursoImpartidoRepository usuarioCursoImpartidoRepository;

	public CursoImpartidoDTO ObtenerCursoImpartidoById(Integer idCursoImpartido) throws Exception {
		return new CursoImpartidoDTO(cursoImpartidoRepository.findById(idCursoImpartido).get());
	}

	@SuppressWarnings("deprecation")
	public CursoImpartidoDTO obtenerCursoById(Integer idCurso) throws Exception {
		String sql = "SELECT\r\n" + "     one_it_curso_id as idCurso, \r\n" + "     one_it_curso_nombre as nombre,\r\n"
				+ "     one_it_curso_horario,\r\n" + "     one_it_curso_total_sesiones as totalSesiones, \r\n"
				+ "     one_it_curso_total_horas as totalHoras,\r\n" + "     one_it_curso_modalidad as diasCurso\r\n"
				+ " FROM \r\n" + " one_it_curso\r\n" + " WHERE \r\n" + " one_it_curso_id = ?";
		List<CursoImpartidoDTO> proyectos = new ArrayList<CursoImpartidoDTO>();
		proyectos = jdbcTemplate.query(sql, new Object[] { idCurso }, (rs, rowNum) -> {
			CursoImpartidoDTO p = new CursoImpartidoDTO();
			p.setIdCurso(rs.getInt("idCurso"));
			p.setNombre(rs.getString("nombre"));
			String horaInicioFin = rs.getString("one_it_curso_horario");
			String[] horasInicioFin = horaInicioFin.replace(" ", "").split("-");
			p.setHoraInicio(horasInicioFin[0]);
			p.setHoraFin(horasInicioFin[1]);

			p.setTotalSesiones(rs.getInt("totalSesiones"));
			p.setTotalHoras(rs.getInt("totalHoras"));
			return p;
		});
		return proyectos.get(0);
	}

	@SuppressWarnings("deprecation")
	public List<CursoImpartidoDTO> obterCursos() throws Exception {
		String sql = "SELECT one_it_curso_id , one_it_curso_nombre FROM one_it_curso";
		List<CursoImpartidoDTO> proyectos = new ArrayList<CursoImpartidoDTO>();
		proyectos = jdbcTemplate.query(sql, new Object[] {}, (rs, rowNum) -> {
			CursoImpartidoDTO p = new CursoImpartidoDTO();
			p.setIdCurso(rs.getInt("one_it_curso_id"));
			p.setNombre(rs.getString("one_it_curso_nombre"));
			return p;
		});
		return proyectos;
	}

	@SuppressWarnings("deprecation")
	public List<CursoImpartidoDTO> obtenerCursososImpartidos() throws Exception {
		String sql = " select \r\n" + "ci.id_curso_impartido, \r\n" + "ci.nombre, \r\n" + "ci.fecha_inicio, \r\n"
				+ "ci.fecha_fin,\r\n"
				+ "concat(p.nombre, ' ', p.primer_Apellido, ' ', ISNULL(p.segundo_apellido,'')) instructor,\r\n"
				+ "(select count(*) from usuario_curso_impartido uci where uci.id_curso_impartido = ci.id_curso_impartido ) numAlumnos,\r\n"
				+ "cd.descripcion as modalidad\r\n" + "from curso_impartido ci \r\n"
				+ "join usuario u on ci.id_instructor = u.id_usuario \r\n"
				+ "join persona p on p.id_usuario = u.id_usuario \r\n"
				+ "join cat_detalle cd on cd.id_cat_detalle = ci.id_modalidad order by p.fecha_alta desc  \r\n" + "";
		;
		List<CursoImpartidoDTO> proyectos = new ArrayList<CursoImpartidoDTO>();
		proyectos = jdbcTemplate.query(sql, new Object[] {}, (rs, rowNum) -> {
			CursoImpartidoDTO p = new CursoImpartidoDTO();
			p.setNombre(rs.getString("nombre"));
			p.setFechaInicioFormat(rs.getDate("fecha_inicio"));
			p.setFechaFinFormat(rs.getDate("fecha_fin"));
			p.setNombreInstructor(rs.getString("instructor"));
			p.setTotalAlumnos(rs.getInt("numAlumnos"));
			p.setModalidad(rs.getString("modalidad"));
			p.setIdCursoImpartido(rs.getInt("id_curso_impartido"));
			return p;
		});
		return proyectos;
	}

	public void agregarAlumnoCurso(UsuarioCursoImpartido obj) throws Exception {
		usuarioCursoImpartidoRepository.save(obj);
	}

	public CursoImpartidoDTO guardarCurso(CursoImpartidoDTO dto) throws Exception {
		CursoImpartido entity = new CursoImpartido(dto);
		cursoImpartidoRepository.save(entity);
		return new CursoImpartidoDTO(entity);
	}

}
