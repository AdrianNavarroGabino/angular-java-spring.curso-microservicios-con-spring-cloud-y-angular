package com.adriannavarrogabino.microservicios.cursos.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.adriannavarrogabino.microservicios.commons.alumnos.models.entity.Alumno;
import com.adriannavarrogabino.microservicios.commons.controllers.CommonController;
import com.adriannavarrogabino.microservicios.commons.examenes.models.entity.Examen;
import com.adriannavarrogabino.microservicios.cursos.models.entity.Curso;
import com.adriannavarrogabino.microservicios.cursos.models.entity.CursoAlumno;
import com.adriannavarrogabino.microservicios.cursos.models.services.ICursoService;

@RestController
public class CursoController extends CommonController<Curso, ICursoService> {
	
	@Value("${config.balanceador.test}")
	private String balanceadorTest;
	
	@GetMapping("/pagina")
	@Override
	public ResponseEntity<?> listar()
	{
		List<Curso> cursos = service.findAll().stream().map(c -> {
			c.getCursoAlumnos().forEach(ca -> {
				Alumno alumno = new Alumno();
				alumno.setId(ca.getAlumnoId());
				c.addAlumno(alumno);
			});
			return c;
		}).collect(Collectors.toList());
		return ResponseEntity.ok().body(cursos);
	}
	
	@GetMapping("/pagina")
	@Override
	public ResponseEntity<?> listar(Pageable pageable)
	{
		Page<Curso> cursos = service.findAll(pageable).map(curso -> {
			curso.getCursoAlumnos().forEach(ca -> {
				Alumno alumno = new Alumno();
				alumno.setId(ca.getAlumnoId());
				curso.addAlumno(alumno);
			});
			return curso;
		});
		
		return ResponseEntity.ok().body(cursos);
	}
	
	@GetMapping("/{id}")
	@Override
	public ResponseEntity<?> ver(@PathVariable Long id)
	{
		Curso curso = service.findById(id);
		
		if(curso == null)
		{
			return ResponseEntity.notFound().build();
		}
		
		if(!curso.getCursoAlumnos().isEmpty()) {
			List<Long> ids = curso.getCursoAlumnos().stream()
					.map(ca -> ca.getAlumnoId()).collect(Collectors.toList());
			
			List<Alumno> alumnos = (List<Alumno>) service.obtenerAlumnosPorCurso(ids);
			
			curso.setAlumnos(alumnos);
		}
		
		return ResponseEntity.ok().body(curso);
	}
	
	@GetMapping("/balanceador-test")
	public ResponseEntity<?> balanceadorTest() {
		
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("balanceadorTest", balanceadorTest);
		response.put("cursos", service.findAll());
		return ResponseEntity.ok(response);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@Valid @RequestBody Curso curso, BindingResult result, @PathVariable Long id) {
		
		if(result.hasErrors()) {
			return validar(result);
		}
		
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
			
			CursoAlumno cursoAlumno = new CursoAlumno();
			cursoAlumno.setAlumnoId(a.getId());
			cursoAlumno.setCurso(cursoDb);
			cursoDb.addCursoAlumno(cursoAlumno);
		});
		
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(cursoDb));
	}
	
	@PutMapping("/{id}/eliminar-alumno")
	public ResponseEntity<?> eliminarAlumno(@RequestBody Alumno alumno, @PathVariable Long id) {
		
		Curso cursoDb = this.service.findById(id);
		
		if(cursoDb == null) {
			return ResponseEntity.notFound().build();
		}
		
		CursoAlumno cursoAlumno = new CursoAlumno();
		cursoAlumno.setAlumnoId(alumno.getId());
		cursoDb.removeCursoAlumno(cursoAlumno);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(cursoDb));
	}
	
	@GetMapping("/alumno/{id}")
	public ResponseEntity<?> buscarAlumnoId(@PathVariable Long id) {
		
		Curso curso = service.findCursoByAlumnoId(id);
		
		if(curso != null) {
			
			List<Long> examenesId = (List<Long>) service.obtenerExamenesIdsConRespuestasAlumno(id);
			
			List<Examen> examenes = curso.getExamenes().stream().map(examen -> {
				if(examenesId.contains(examen.getId())) {
					examen.setRespondido(true);
				}
				return examen;
			}).collect(Collectors.toList());
			
			curso.setExamenes(examenes);
		}
		return ResponseEntity.ok().body(curso);
	}
	
	@PutMapping("/{id}/asignar-examenes")
	public ResponseEntity<?> asignarExamenes(@RequestBody List<Examen> examenes, @PathVariable Long id) {
		
		Curso cursoDb = this.service.findById(id);
		
		if(cursoDb == null) {
			return ResponseEntity.notFound().build();
		}
		
		examenes.forEach(e -> {
			cursoDb.addExamen(e);
		});
		
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(cursoDb));
	}
	
	@PutMapping("/{id}/eliminar-examen")
	public ResponseEntity<?> eliminarExamen(@RequestBody Examen examen, @PathVariable Long id) {
		
		Curso cursoDb = this.service.findById(id);
		
		if(cursoDb == null) {
			return ResponseEntity.notFound().build();
		}
		
		cursoDb.removeExamen(examen);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(cursoDb));
	}

}
