package com.adriannavarrogabino.microservicios.cursos.models.services;

import com.adriannavarrogabino.microservicios.commons.services.ICommonService;
import com.adriannavarrogabino.microservicios.cursos.models.entity.Curso;

public interface ICursoService extends ICommonService<Curso> {

	public Curso findCursoByAlumnoId(Long id);
}
