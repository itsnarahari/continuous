package com.continuous.practice;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SetterAndGetterTest {

    private int id;
    private String name;

    public String getName() {
        name="addedString "+name;
        return name;
    }
}

