package com.adriannavarrogabino.microservicios.usuarios.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.adriannavarrogabino.microservicios.usuarios.models.entity.Alumno;

public interface IAlumnoDao extends CrudRepository<Alumno, Long> {

	
}
