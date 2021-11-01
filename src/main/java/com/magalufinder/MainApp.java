package com.magalufinder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EntityScan(basePackages = "com.magalufinder.models")  // scan JPA entities
public class MainApp {

	public static void main(String[] args) {
		SpringApplication.run(MainApp.class, args);
	}
}
