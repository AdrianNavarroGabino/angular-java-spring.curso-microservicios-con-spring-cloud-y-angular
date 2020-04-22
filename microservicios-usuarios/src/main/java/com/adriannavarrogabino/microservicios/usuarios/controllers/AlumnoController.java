package com.adriannavarrogabino.microservicios.usuarios.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@PostMapping
	public ResponseEntity<?> crear(@RequestBody Alumno alumno)
	{
		Alumno alumnoDb = alumnoService.save(alumno);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(alumnoDb);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@RequestBody Alumno alumno, @PathVariable Long id)
	{
		Alumno alumnoDb = alumnoService.findById(id);
		
		if(alumnoDb == null)
		{
			return ResponseEntity.notFound().build();
		}
		
		alumnoDb.setNombre(alumno.getNombre());
		alumnoDb.setApellido(alumno.getApellido());
		alumnoDb.setEmail(alumno.getEmail());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(alumnoService.save(alumnoDb));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Long id)
	{
		Alumno alumnoDb = alumnoService.findById(id);
		
		if(alumnoDb == null)
		{
			return ResponseEntity.notFound().build();
		}
		
		alumnoService.deleteById(id);
		
		return ResponseEntity.noContent().build();
	}
}
