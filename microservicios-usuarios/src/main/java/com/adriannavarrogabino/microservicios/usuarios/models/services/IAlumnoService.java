package com.adriannavarrogabino.microservicios.usuarios.models.services;

import java.util.List;

import com.adriannavarrogabino.microservicios.commons.alumnos.models.entity.Alumno;
import com.adriannavarrogabino.microservicios.commons.services.ICommonService;

public interface IAlumnoService extends ICommonService<Alumno> {
	
	public List<Alumno> findByNombreOApellido(String term);
}
