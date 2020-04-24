package com.adriannavarrogabino.microservicios.commons.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICommonService<E> {
	
	public List<E> findAll();
	
	public Page<E> findAll(Pageable pageable);
	
	public E findById(Long id);
	
	public E save(E entity);
	
	public void deleteById(Long id);
}
