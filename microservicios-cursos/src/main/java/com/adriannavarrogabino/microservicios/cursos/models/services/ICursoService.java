package com.adriannavarrogabino.microservicios.cursos.models.services;

import java.util.List;

import com.adriannavarrogabino.microservicios.commons.alumnos.models.entity.Alumno;
import com.adriannavarrogabino.microservicios.commons.services.ICommonService;
import com.adriannavarrogabino.microservicios.cursos.models.entity.Curso;

public interface ICursoService extends ICommonService<Curso> {

	public Curso findCursoByAlumnoId(Long id);
	
	public Iterable<Long> obtenerExamenesIdsConRespuestasAlumno(Long alumnoId);
	
	public Iterable<Alumno> obtenerAlumnosPorCurso(List<Long> ids);
}
