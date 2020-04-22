package com.adriannavarrogabino.microservicios.usuarios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

// No es necesaria esta anotación porque ya está en el pom, pero siempre es mejor hacerlo explícito
@EnableEurekaClient
@SpringBootApplication
public class MicroserviciosUsuariosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviciosUsuariosApplication.class, args);
	}

}
