package com.cognizant.eurekadiscoveryserve;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
//enable eureka server
@EnableEurekaServer
public class EurekaDiscoveryServeApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaDiscoveryServeApplication.class, args);
	}

}
