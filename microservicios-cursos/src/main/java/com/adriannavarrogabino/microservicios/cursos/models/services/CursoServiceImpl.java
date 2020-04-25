package com.adriannavarrogabino.microservicios.cursos.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adriannavarrogabino.microservicios.commons.alumnos.models.entity.Alumno;
import com.adriannavarrogabino.microservicios.commons.services.CommonServiceImpl;
import com.adriannavarrogabino.microservicios.cursos.clients.IAlumnoFeignClient;
import com.adriannavarrogabino.microservicios.cursos.clients.RespuestaFeignClient;
import com.adriannavarrogabino.microservicios.cursos.models.entity.Curso;
import com.adriannavarrogabino.microservicios.cursos.models.repository.ICursoRepository;

@Service
public class CursoServiceImpl extends CommonServiceImpl<Curso, ICursoRepository> implements ICursoService {

	@Autowired
	private RespuestaFeignClient client;
	
	@Autowired
	private IAlumnoFeignClient clientAlumno;
	
	@Override
	@Transactional(readOnly = true)
	public Curso findCursoByAlumnoId(Long id) {
		
		return repository.findCursoByAlumnoId(id);
	}

	@Override
	public Iterable<Long> obtenerExamenesIdsConRespuestasAlumno(Long alumnoId) {
		
		return client.obtenerExamenesIdsConRespuestasAlumno(alumnoId);
	}

	@Override
	public Iterable<Alumno> obtenerAlumnosPorCurso(List<Long> ids) {
		
		return clientAlumno.obtenerAlumnosPorCurso(ids);
	}

}
