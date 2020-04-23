package com.adriannavarrogabino.microservicios.examenes.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adriannavarrogabino.microservicios.commons.examenes.models.entity.Asignatura;
import com.adriannavarrogabino.microservicios.commons.examenes.models.entity.Examen;
import com.adriannavarrogabino.microservicios.commons.services.CommonServiceImpl;
import com.adriannavarrogabino.microservicios.examenes.models.repository.IAsignaturaRepository;
import com.adriannavarrogabino.microservicios.examenes.models.repository.IExamenRepository;

@Service
public class ExamenServiceImpl extends CommonServiceImpl<Examen, IExamenRepository> implements IExamenService {
	
	@Autowired
	private IAsignaturaRepository asignaturaRepository;

	@Override
	@Transactional(readOnly = true)
	public List<Examen> findByNombre(String term) {
		
		return repository.findByNombre(term);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Asignatura> findAllAsignaturas() {
		
		return (List<Asignatura>) asignaturaRepository.findAll();
	}

}
