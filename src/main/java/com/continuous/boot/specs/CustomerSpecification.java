package com.continuous.boot.specs;

import org.springframework.stereotype.Component;

import java.util.stream.IntStream;

@Component
public class CustomerSpecification {

    public static void main(String[] args) {
        String str = "ghghgf";
        IntStream intStream = str.chars();
        intStream.forEach(i -> System.out.println(i));
    }
}
