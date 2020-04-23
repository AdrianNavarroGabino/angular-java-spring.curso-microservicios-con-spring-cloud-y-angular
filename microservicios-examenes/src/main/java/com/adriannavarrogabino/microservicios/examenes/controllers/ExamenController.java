package com.adriannavarrogabino.microservicios.examenes.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.adriannavarrogabino.microservicios.commons.controllers.CommonController;
import com.adriannavarrogabino.microservicios.commons.examenes.models.entity.Examen;
import com.adriannavarrogabino.microservicios.examenes.models.services.IExamenService;

@RestController
public class ExamenController extends CommonController<Examen, IExamenService> {

	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@RequestBody Examen examen, @PathVariable Long id) {
		
		Examen examenBd = service.findById(id);
		
		if(examenBd == null)
		{
			return ResponseEntity.notFound().build();
		}
		
		
		examenBd.setNombre(examen.getNombre());
		
		examenBd.getPreguntas().stream()
			.filter(pdb -> examen.getPreguntas().contains(pdb))
			.forEach(examenBd::removePregunta);
		
		examenBd.setPreguntas(examen.getPreguntas());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(examenBd));
	}
	
	@GetMapping("/filtrar/{term}")
	public ResponseEntity<?> filtrar(@PathVariable String term) {
		
		return ResponseEntity.ok().body(service.findByNombre(term));
	}
}
