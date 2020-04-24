package com.adriannavarrogabino.microservicios.commons.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CommonServiceImpl<E, R extends PagingAndSortingRepository<E, Long>> implements ICommonService<E> {
	
	@Autowired
	protected R repository;

	@Override
	@Transactional(readOnly = true)
	public List<E> findAll() {
		
		return (List<E>) repository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public E findById(Long id) {
		
		return repository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public E save(E entity) {
		
		return repository.save(entity);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		
		repository.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<E> findAll(Pageable pageable) {
		
		return repository.findAll(pageable);
	}

}
