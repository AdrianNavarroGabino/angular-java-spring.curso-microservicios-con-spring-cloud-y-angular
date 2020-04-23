package com.adriannavarrogabino.microservicios.examenes.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.adriannavarrogabino.microservicios.commons.examenes.models.entity.Asignatura;

public interface IAsignaturaRepository extends CrudRepository<Asignatura, Long> {

}
