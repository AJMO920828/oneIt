package com.mx.oneIt.api.service;

import java.util.List;

import com.mx.oneIt.api.dto.CatDetalleDTO;

public interface CatDetalleService {
	public List<CatDetalleDTO> findByCatDetalle(Integer idCatMaestro,Integer indEstatus) throws Exception;
}
