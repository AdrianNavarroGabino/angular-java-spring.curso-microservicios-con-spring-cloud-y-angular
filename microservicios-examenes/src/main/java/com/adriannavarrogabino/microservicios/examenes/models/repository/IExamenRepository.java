package com.adriannavarrogabino.microservicios.examenes.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.adriannavarrogabino.microservicios.commons.examenes.models.entity.Examen;

public interface IExamenRepository extends PagingAndSortingRepository<Examen, Long> {

	@Query("select e from Examen e where e.nombre like %?!%")
	public List<Examen> findByNombre(String term);
}
