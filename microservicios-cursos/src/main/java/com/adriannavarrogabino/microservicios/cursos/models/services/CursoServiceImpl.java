package com.adriannavarrogabino.microservicios.cursos.models.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adriannavarrogabino.microservicios.commons.services.CommonServiceImpl;
import com.adriannavarrogabino.microservicios.cursos.models.entity.Curso;
import com.adriannavarrogabino.microservicios.cursos.models.repository.ICursoRepository;

@Service
public class CursoServiceImpl extends CommonServiceImpl<Curso, ICursoRepository> implements ICursoService {

	@Override
	@Transactional(readOnly = true)
	public Curso findCursoByAlumnoId(Long id) {
		
		return repository.findCursoByAlumnoId(id);
	}

}
