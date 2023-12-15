package com.docker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
//@ComponentScan(basePackages = "com.docker.controller")
public class DockerTestApplication {
	public static void main(String[] args) {
		System.out.println("Starting point");
		SpringApplication.run(DockerTestApplication.class, args);
	}

}