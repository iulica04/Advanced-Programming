package com.example.laborator_11;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories("com.example.laborator_11.repository")
@EntityScan("com.example.laborator_11.entity")
public class Laborator11Application {

	public static void main(String[] args) {
		SpringApplication.run(Laborator11Application.class, args);
	}


}
