package com.adriannavarrogabino.microservicios.usuarios.models.services;

import java.util.List;

import com.adriannavarrogabino.microservicios.usuarios.models.entity.Alumno;

public interface IAlumnoService {
	
	public List<Alumno> findAll();
	
	public Alumno findById(Long id);
	
	public Alumno save(Alumno alumno);
	
	public void deleteById(Long id);
}
