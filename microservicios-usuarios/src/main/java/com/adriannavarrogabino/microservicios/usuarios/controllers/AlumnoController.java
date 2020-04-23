package com.adriannavarrogabino.microservicios.usuarios.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.adriannavarrogabino.microservicios.commons.alumnos.models.entity.Alumno;
import com.adriannavarrogabino.microservicios.commons.controllers.CommonController;
import com.adriannavarrogabino.microservicios.usuarios.models.services.IAlumnoService;

@RestController
public class AlumnoController extends CommonController<Alumno, IAlumnoService> {
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@RequestBody Alumno alumno, @PathVariable Long id)
	{
		Alumno alumnoDb = service.findById(id);
		
		if(alumnoDb == null)
		{
			return ResponseEntity.notFound().build();
		}
		
		alumnoDb.setNombre(alumno.getNombre());
		alumnoDb.setApellido(alumno.getApellido());
		alumnoDb.setEmail(alumno.getEmail());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(alumnoDb));
	}
	
	@GetMapping("/filtrar/{term}")
	public ResponseEntity<?> filtrar(@PathVariable String term) {
		
		return ResponseEntity.ok().body(service.findByNombreOApellido(term));
	}
}
