package com.docker.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Customer {
    public Customer(int id, String name){
        this.id=id;
        this.name=name;
    }
    private int id;
    private String name;

}
