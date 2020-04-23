package com.adriannavarrogabino.microservicios.usuarios.models.services;

import org.springframework.stereotype.Service;

import com.adriannavarrogabino.microservicios.commons.alumnos.models.entity.Alumno;
import com.adriannavarrogabino.microservicios.commons.services.CommonServiceImpl;
import com.adriannavarrogabino.microservicios.usuarios.models.dao.IAlumnoDao;

@Service
public class AlumnoServiceImpl extends CommonServiceImpl<Alumno, IAlumnoDao> implements IAlumnoService {

}
