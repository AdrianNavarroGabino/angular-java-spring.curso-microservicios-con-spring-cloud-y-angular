package com.adriannavarrogabino.microservicios.respuestas.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.adriannavarrogabino.microservicios.respuestas.models.entity.Respuesta;

public interface IRespuestaRepository extends CrudRepository<Respuesta, Long> {

}
