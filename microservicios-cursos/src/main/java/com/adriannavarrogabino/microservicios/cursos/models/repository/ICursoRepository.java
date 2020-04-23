package com.adriannavarrogabino.microservicios.cursos.models.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.adriannavarrogabino.microservicios.cursos.models.entity.Curso;

public interface ICursoRepository extends CrudRepository<Curso, Long> {
	
	@Query("select c from Curso c join fetch c.alumnos a where a.id = ?1")
	public Curso findCursoByAlumnoId(Long id);

}
