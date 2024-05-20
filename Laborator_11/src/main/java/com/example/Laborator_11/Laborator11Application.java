package com.example.Laborator_11;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.example.Laborator_11.Repository")
@EntityScan("com.example.Laborator_11.Entity")
public class Laborator11Application {

	public static void main(String[] args) {
		SpringApplication.run(Laborator11Application.class, args);
	}

}
