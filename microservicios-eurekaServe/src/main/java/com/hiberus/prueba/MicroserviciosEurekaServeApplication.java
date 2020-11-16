package com.hiberus.prueba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
@EnableEurekaServer
@SpringBootApplication
public class MicroserviciosEurekaServeApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviciosEurekaServeApplication.class, args);
	}

}
