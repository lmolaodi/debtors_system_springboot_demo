package com.example.debtordemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
//Swagger html doc path
@RequestMapping(path = "/api")

public class DebtorDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DebtorDemoApplication.class, args);
	}

}
