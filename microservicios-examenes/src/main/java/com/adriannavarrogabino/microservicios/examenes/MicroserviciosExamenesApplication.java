package com.adriannavarrogabino.microservicios.examenes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@EntityScan({"com.adriannavarrogabino.microservicios.commons.examenes.models.entity",
	"com.adriannavarrogabino.microservicios.commons.alumnos.models.entity",
	"com.adriannavarrogabino.microservicios.cursos.models.entity"})
public class MicroserviciosExamenesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviciosExamenesApplication.class, args);
	}

}
