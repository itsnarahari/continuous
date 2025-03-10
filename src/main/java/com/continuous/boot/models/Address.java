package com.continuous.boot.models;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Address {

    public Address() {
        System.out.println("address called");
    }

    private Long id;
    private String city;
}
