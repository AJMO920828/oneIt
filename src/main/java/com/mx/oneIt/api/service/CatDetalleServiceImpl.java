package com.mx.oneIt.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.mx.oneIt.api.dao.CatDetalleDao;
import com.mx.oneIt.api.dto.CatDetalleDTO;

@Service
public class CatDetalleServiceImpl implements  CatDetalleService {
	@Autowired
	CatDetalleDao catDetalleRepository;
	
	@Override
	@Transactional
	public List<CatDetalleDTO> findByCatDetalle(Integer idCatMaestro, Integer indEstatus) throws Exception {
		List<CatDetalleDTO> cat = catDetalleRepository.findByCatDetalle(idCatMaestro,indEstatus);
		return cat;
	}
}
