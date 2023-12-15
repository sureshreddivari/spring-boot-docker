package com.docker.service;

import com.docker.dao.CustomerDao;
import com.docker.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerDao customerDao;

    public List<Customer> loadAllCustomers() {
        long before= System.currentTimeMillis();
        List<Customer> customers= customerDao.getCustomers();
        long after= System.currentTimeMillis();
        System.out.println("executed time::"+ (after-before));
        return customers;
    }

    public Flux<Customer> loadAllCustomersStream() {
        long before= System.currentTimeMillis();
        Flux<Customer> customers= customerDao.getCustomersStream();
        long after= System.currentTimeMillis();
        System.out.println("executed time::"+ (after-before));
        return customers;
    }

    public Flux<String> fetchData(int numberOfRows) {
        return Flux.range(1, numberOfRows)
                .map(i -> "Data " + i)
                .delayElements(java.time.Duration.ofMillis(10));
    }
}
