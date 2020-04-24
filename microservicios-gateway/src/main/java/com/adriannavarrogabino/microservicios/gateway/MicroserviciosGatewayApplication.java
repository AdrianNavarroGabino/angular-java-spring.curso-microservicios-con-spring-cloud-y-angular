package com.adriannavarrogabino.microservicios.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

// Alternativa a zuul creada por Spring en lugar de por Netflix
@EnableEurekaClient
@SpringBootApplication
public class MicroserviciosGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviciosGatewayApplication.class, args);
	}

}
