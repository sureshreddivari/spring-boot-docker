package com.docker.controller;

import com.docker.entity.Customer;
import com.docker.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;

@RequestMapping("/customers")
@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/")
    public ResponseEntity<List<Customer>> getCustomers() {
        return ResponseEntity.ok(customerService.loadAllCustomers());
    }
    @GetMapping(value= "/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Customer> getCustomersStream() {
        return customerService.loadAllCustomersStream();
    }

    @GetMapping(value= "/rows", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> getData(@RequestParam(defaultValue = "100000") int numberOfRows) {
        return customerService.fetchData(numberOfRows);
    }
}
