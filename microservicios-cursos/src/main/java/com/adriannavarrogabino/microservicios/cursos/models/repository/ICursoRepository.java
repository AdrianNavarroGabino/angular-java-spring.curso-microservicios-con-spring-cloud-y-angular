package com.adriannavarrogabino.microservicios.cursos.models.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.adriannavarrogabino.microservicios.cursos.models.entity.Curso;

public interface ICursoRepository extends PagingAndSortingRepository<Curso, Long> {
	
	@Query("select c from Curso c join fetch c.cursoAlumnos a where a.alumnoId = ?1")
	public Curso findCursoByAlumnoId(Long id);

}
