package com.adriannavarrogabino.microservicios.cursos.models.services;

import org.springframework.stereotype.Service;

import com.adriannavarrogabino.microservicios.commons.services.CommonServiceImpl;
import com.adriannavarrogabino.microservicios.cursos.models.entity.Curso;
import com.adriannavarrogabino.microservicios.cursos.models.repository.ICursoRepository;

@Service
public class CursoServiceImpl extends CommonServiceImpl<Curso, ICursoRepository> implements ICursoService {

}
