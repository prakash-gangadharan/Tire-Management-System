package io.tiremanagement.springsecurityjwt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class TMSAuthServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TMSAuthServiceApplication.class, args);
	}

}