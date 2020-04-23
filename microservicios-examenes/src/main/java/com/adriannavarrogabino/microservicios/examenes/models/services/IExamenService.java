package com.adriannavarrogabino.microservicios.examenes.models.services;

import java.util.List;

import com.adriannavarrogabino.microservicios.commons.examenes.models.entity.Examen;
import com.adriannavarrogabino.microservicios.commons.services.ICommonService;

public interface IExamenService extends ICommonService<Examen> {

	public List<Examen> findByNombre(String term);
}
