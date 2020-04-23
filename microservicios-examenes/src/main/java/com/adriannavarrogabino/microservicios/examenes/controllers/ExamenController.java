package com.adriannavarrogabino.microservicios.examenes.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.adriannavarrogabino.microservicios.commons.controllers.CommonController;
import com.adriannavarrogabino.microservicios.examenes.models.entity.Examen;
import com.adriannavarrogabino.microservicios.examenes.models.services.IExamenService;

@RestController
public class ExamenController extends CommonController<Examen, IExamenService> {

	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@RequestBody Examen examen, @PathVariable Long id) {
		
		return null;
	}
}
