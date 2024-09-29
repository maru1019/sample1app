package com.example.sample1app;

import java.util.Arrays;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.Banner.Mode;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Sample1appApplication implements ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(Sample1appApplication.class);
		app.setBannerMode(Mode.OFF);
		app.run(args);
	}

	@Override
	public void run(ApplicationArguments args) {
		System.out.println("+--------------------------------------+");
		System.out.println("| this is Application Runner program. |");
		System.out.println("+--------------------------------------+");
		System.out.println(args.getOptionNames());
		System.out.println(args.getNonOptionArgs());
		System.out.println(Arrays.asList(args.getSourceArgs()));
	}
}