package com.adriannavarrogabino.microservicios.commons.services;

import java.util.List;

public interface ICommonService<E> {
	
	public List<E> findAll();
	
	public E findById(Long id);
	
	public E save(E entity);
	
	public void deleteById(Long id);
}
