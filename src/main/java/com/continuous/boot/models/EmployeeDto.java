package com.continuous.boot.models;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EmployeeDto {

    public EmployeeDto() {
        System.out.println("Employee called");
    }

    private Long id;
    private String name;
    private Address address;
}
