package com.cognizant.loan;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
 
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class LoanApplication {
	public static void main(String[] args) {
		SpringApplication.run(LoanApplication.class, args);
	}
	@Bean
//	@LoadBalanced
	// it does the load balancing and also client side discovery
	public RestTemplate getRestTemplate()
	{
		return new RestTemplate();
	}
	
}
