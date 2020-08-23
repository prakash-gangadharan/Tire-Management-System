package com.tiremanagement.registration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class TireManagementSystemRegistrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(TireManagementSystemRegistrationApplication.class, args);
	}

}
