package com.adriannavarrogabino.microservicios.usuarios.models.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adriannavarrogabino.microservicios.commons.alumnos.models.entity.Alumno;
import com.adriannavarrogabino.microservicios.commons.services.CommonServiceImpl;
import com.adriannavarrogabino.microservicios.usuarios.models.dao.IAlumnoDao;

@Service
public class AlumnoServiceImpl extends CommonServiceImpl<Alumno, IAlumnoDao> implements IAlumnoService {

	@Override
	@Transactional(readOnly = true)
	public List<Alumno> findByNombreOApellido(String term) {
		
		return repository.findByNombreOApellido(term);
	}

}
