package com.adriannavarrogabino.microservicios.cursos.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.adriannavarrogabino.microservicios.commons.alumnos.models.entity.Alumno;
import com.adriannavarrogabino.microservicios.commons.controllers.CommonController;
import com.adriannavarrogabino.microservicios.cursos.models.entity.Curso;
import com.adriannavarrogabino.microservicios.cursos.models.services.ICursoService;

@RestController
public class CursoController extends CommonController<Curso, ICursoService> {
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@RequestBody Curso curso, @PathVariable Long id) {
		
		Curso cursoDb = this.service.findById(id);
		
		if(cursoDb == null) {
			return ResponseEntity.notFound().build();
		}
		
		cursoDb.setNombre(curso.getNombre());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(cursoDb));
	}
	
	@PutMapping("/{id}/asignar-alumnos")
	public ResponseEntity<?> asignarAlumnos(@RequestBody List<Alumno> alumnos, @PathVariable Long id) {
		
		Curso cursoDb = this.service.findById(id);
		
		if(cursoDb == null) {
			return ResponseEntity.notFound().build();
		}
		
		alumnos.forEach(a -> {
			cursoDb.addAlumno(a);
		});
		
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(cursoDb));
	}
	
	@PutMapping("/{id}/eliminar-alumno")
	public ResponseEntity<?> eliminarAlumno(@RequestBody Alumno alumno, @PathVariable Long id) {
		
		Curso cursoDb = this.service.findById(id);
		
		if(cursoDb == null) {
			return ResponseEntity.notFound().build();
		}
		
		cursoDb.removeAlumno(alumno);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(cursoDb));
	}
	
	@GetMapping("/alumno/{id}")
	public ResponseEntity<?> buscarAlumnoId(@PathVariable Long id) {
		
		return ResponseEntity.ok().body(service.findCursoByAlumnoId(id));
	}

}
