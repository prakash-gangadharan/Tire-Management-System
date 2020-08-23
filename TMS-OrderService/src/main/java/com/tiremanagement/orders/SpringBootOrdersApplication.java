package com.tiremanagement.orders;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringBootOrdersApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootOrdersApplication.class, args);
	}
}
