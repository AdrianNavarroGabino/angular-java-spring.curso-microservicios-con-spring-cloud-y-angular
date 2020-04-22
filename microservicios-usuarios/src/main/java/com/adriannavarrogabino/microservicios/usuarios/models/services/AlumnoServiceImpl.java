package com.adriannavarrogabino.microservicios.usuarios.models.services;

import org.springframework.stereotype.Service;
import com.adriannavarrogabino.microservicios.commons.services.CommonServiceImpl;
import com.adriannavarrogabino.microservicios.usuarios.models.dao.IAlumnoDao;
import com.adriannavarrogabino.microservicios.usuarios.models.entity.Alumno;

@Service
public class AlumnoServiceImpl extends CommonServiceImpl<Alumno, IAlumnoDao> implements IAlumnoService {

}
