package com.adriannavarrogabino.microservicios.respuestas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@EntityScan({"com.adriannavarrogabino.microservicios.respuestas.models.entity",
	"com.adriannavarrogabino.microservicios.commons.alumnos.models.entity",
	"com.adriannavarrogabino.microservicios.commons.examenes.models.entity"})
public class MicroserviciosRespuestasApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviciosRespuestasApplication.class, args);
	}

}
