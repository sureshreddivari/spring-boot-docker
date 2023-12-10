package com.docker.DockerTest;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DockerTestApplicationTests {

    @Test
    void contextLoads() {
    }

    @LocalServerPort
    private int port;

    private String baseURL = "http://localhost";

    private static RestTemplate restTemplate;

    @BeforeAll
    public static void init() {
        restTemplate = new RestTemplate();
    }

    @BeforeEach
    public void setup() {
        baseURL = baseURL.concat(":").concat(port + "").concat("/api/hi");
    }

    @Test
    public void test1() {
        System.out.println(baseURL);

        String response = restTemplate.getForObject(baseURL, String.class);

        assertEquals("Hello hi my docker first application", response);
    }

    @Test
    public void test2() {
        System.out.println(baseURL);

        String response = restTemplate.getForObject(baseURL, String.class);

        assertNotEquals("docker first application", response);
    }


}
