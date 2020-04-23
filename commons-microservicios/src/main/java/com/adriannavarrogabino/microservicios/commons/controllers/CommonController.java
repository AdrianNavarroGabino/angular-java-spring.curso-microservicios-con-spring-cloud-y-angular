package com.adriannavarrogabino.microservicios.commons.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.adriannavarrogabino.microservicios.commons.services.ICommonService;

@RestController
public class CommonController<E, S extends ICommonService<E>> {
	
	@Autowired
	protected S service;

	@GetMapping
	public ResponseEntity<?> listar()
	{
		return ResponseEntity.ok().body(service.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> ver(@PathVariable Long id)
	{
		E entity = service.findById(id);
		
		if(entity == null)
		{
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok().body(entity);
	}
	
	@PostMapping
	public ResponseEntity<?> crear(@Valid @RequestBody E entity, BindingResult result) {
		
		if(result.hasErrors()) {
			return validar(result);
		}
		E entityDb = service.save(entity);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(entityDb);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Long id)
	{
		E entityDb = service.findById(id);
		
		if(entityDb == null)
		{
			return ResponseEntity.notFound().build();
		}
		
		service.deleteById(id);
		
		return ResponseEntity.noContent().build();
	}
	
	protected ResponseEntity<?> validar(BindingResult result) {
		Map<String, Object> errores = new HashMap<>();
		result.getFieldErrors().forEach(err -> errores.put(err.getField(), err.getDefaultMessage()));
		return ResponseEntity.badRequest().body(result);
	}
}
