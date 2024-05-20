package com.example.Laborator_11;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("ControllerPackage")
public class Laborator11Application {

	public static void main(String[] args) {
		SpringApplication.run(Laborator11Application.class, args);
	}

}
