package com.microservices.ratingservice.ratingmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RatingmicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RatingmicroserviceApplication.class, args);
	}

}
