package com.test.boot.models;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Employee {

    public Employee() {
        System.out.println("Employee called");
    }

    private Long id;
    private String name;
    private Address address;
}
