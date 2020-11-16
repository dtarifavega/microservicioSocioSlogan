package com.hiberus.prueba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
@EnableEurekaClient
@SpringBootApplication
public class MicroserviciosGatewayAcmeApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviciosGatewayAcmeApplication.class, args);
	}

}
