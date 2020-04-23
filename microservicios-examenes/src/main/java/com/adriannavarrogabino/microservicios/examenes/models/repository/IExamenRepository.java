package com.adriannavarrogabino.microservicios.examenes.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.adriannavarrogabino.microservicios.commons.examenes.models.entity.Examen;

public interface IExamenRepository extends CrudRepository<Examen, Long> {

}
