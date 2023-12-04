package com.docker.DockerTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class DockerTestApplication {

	@GetMapping("/hi")
	public String hi(){
		return "Hello hi my docker first application";
	}
	public static void main(String[] args) {
		SpringApplication.run(DockerTestApplication.class, args);
	}

}