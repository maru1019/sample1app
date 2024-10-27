package com.example.sample1app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.example.sample1app.entities.Post;
import org.springframework.web.client.RestTemplate; 
import org.springframework.boot.web.client.RestTemplateBuilder;


@SpringBootApplication
public class Sample1appApplication {

	public static void main(String[] args) {
		SpringApplication.run(Sample1appApplication.class, args);
	}

	@Bean
	public Post post() {
		return new Post (0, 0, "Dummy", "This is dummy post.");
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
}