package com.example.sd2020.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import repository.LoginRepo;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		new LoginRepo();
		SpringApplication.run(DemoApplication.class, args);
	}

}
