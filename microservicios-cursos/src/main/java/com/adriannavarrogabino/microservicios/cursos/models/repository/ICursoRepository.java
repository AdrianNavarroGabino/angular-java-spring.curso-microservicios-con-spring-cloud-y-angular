package com.adriannavarrogabino.microservicios.cursos.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.adriannavarrogabino.microservicios.cursos.models.entity.Curso;

public interface ICursoRepository extends CrudRepository<Curso, Long> {

}
