package com.mx.oneIt.api.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mx.oneIt.api.dao.CursoImpartidoDao;
import com.mx.oneIt.api.dto.CursoImpartidoDTO;
import com.mx.oneIt.api.model.UsuarioCursoImpartido;

@Service
public class CursoImpartidoServiceImpl {
	@Autowired
	private CursoImpartidoDao cursosoDao;

	@Transactional
	public CursoImpartidoDTO ObtenerCursoImpartidoById(Integer idCursoImpartido) throws Exception{
		return cursosoDao.ObtenerCursoImpartidoById(idCursoImpartido);
	}

	@Transactional
	public List<CursoImpartidoDTO> obtenerCursososImpartidos() throws Exception{
		return cursosoDao.obtenerCursososImpartidos();
	}
	
	
	@Transactional
	public CursoImpartidoDTO obtenerCursoById(Integer idCurso) throws Exception{
		return cursosoDao.obtenerCursoById(idCurso);
	}
	
	@Transactional
	public List<CursoImpartidoDTO> obterCursos() throws Exception{
		return cursosoDao.obterCursos();
	}
	
	@Transactional
	public void agregarAlumnoCurso(UsuarioCursoImpartido obj) throws Exception{
		cursosoDao.agregarAlumnoCurso(obj);
	}
	
	@Transactional
	public CursoImpartidoDTO guardarCurso(CursoImpartidoDTO dto) throws Exception{
		return cursosoDao.guardarCurso(dto);	
	}
	
}
