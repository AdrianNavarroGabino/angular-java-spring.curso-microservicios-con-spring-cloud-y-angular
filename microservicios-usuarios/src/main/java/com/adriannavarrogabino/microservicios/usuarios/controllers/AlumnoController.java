package com.adriannavarrogabino.microservicios.usuarios.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.adriannavarrogabino.microservicios.usuarios.models.entity.Alumno;
import com.adriannavarrogabino.microservicios.usuarios.models.services.IAlumnoService;

@RestController
public class AlumnoController {
	
	@Autowired
	private IAlumnoService alumnoService;

	@GetMapping
	public ResponseEntity<?> listar()
	{
		return ResponseEntity.ok().body(alumnoService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> ver(@PathVariable Long id)
	{
		Alumno alumno = alumnoService.findById(id);
		
		if(alumno == null)
		{
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok().body(alumno);
	}
}
