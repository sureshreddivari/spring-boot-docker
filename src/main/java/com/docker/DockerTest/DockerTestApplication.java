package com.docker.DockerTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = "com.docker")
public class DockerTestApplication {

	public static void main(String[] args) {
		System.out.println("Starting point");
		SpringApplication.run(DockerTestApplication.class, args);
	}

}