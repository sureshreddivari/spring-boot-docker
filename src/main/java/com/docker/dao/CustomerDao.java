package com.docker.dao;

import com.docker.entity.Customer;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
@Component
public class CustomerDao {

    public static void delay(int i){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Customer> getCustomers() {
        return IntStream.rangeClosed(1, 10).
                peek(i -> System.out.println("processing data" + i)).
                peek(CustomerDao::delay).
                mapToObj(i -> new Customer(1, "customer" + i)).
                collect(Collectors.toList());
    }

    public Flux<Customer> getCustomersStream() {
        return Flux.range(1, 10).
                delayElements(Duration.ofSeconds(1)).
                doOnNext(i -> System.out.println("processing data" + i)).
                map(i -> new Customer(1, "customer" + i));
    }
}
