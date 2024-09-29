package com.example.sample1app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.Banner.Mode;

@SpringBootApplication
public class Sample1appApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(Sample1appApplication.class);
		app.setBannerMode(Mode.OFF);
		app.run(args);
	}
}
