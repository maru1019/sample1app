package com.example.sample1app;

import javax.swing.JFrame;
import javax.swing.JLabel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@RestController
public class Sample1appApplication {

	public static void main(String[] args) {
		SpringApplication.run(Sample1appApplication.class, args);
	}

	@RequestMapping("/")
	public String index() {
		return "Hello, Spring Boot 3!!!";
	}
}