package com.example.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example")
public class ComApplication {

	public static void main(String[] args) {
		SpringApplication.run(ComApplication.class, args);
	}

}
