package com.adriannavarrogabino.microservicios.usuarios.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.adriannavarrogabino.microservicios.commons.alumnos.models.entity.Alumno;

public interface IAlumnoDao extends PagingAndSortingRepository<Alumno, Long> {

	@Query("select a from Alumno a where upper(a.nombre) like upper(concat('%', ?1, '%')) or upper(a.apellido) like upper(concat('%', ?1, '%'))")
	public List<Alumno> findByNombreOApellido(String term);
}
