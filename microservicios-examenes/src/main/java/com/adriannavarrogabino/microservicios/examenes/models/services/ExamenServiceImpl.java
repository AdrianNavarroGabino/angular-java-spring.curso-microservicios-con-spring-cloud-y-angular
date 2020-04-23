package com.adriannavarrogabino.microservicios.examenes.models.services;

import org.springframework.stereotype.Service;

import com.adriannavarrogabino.microservicios.commons.services.CommonServiceImpl;
import com.adriannavarrogabino.microservicios.examenes.models.entity.Examen;
import com.adriannavarrogabino.microservicios.examenes.models.repository.IExamenRepository;

@Service
public class ExamenServiceImpl extends CommonServiceImpl<Examen, IExamenRepository> implements IExamenService {

}
