package com.continuous.practice.utils;

import java.util.stream.IntStream;

public class Java8Star {

    public static void main(String[] args) {

        IntStream.range(0, 5).forEach(i -> {
            IntStream.range(i, 0).forEach(j -> System.out.print(" "));
            IntStream.range(i, 5).forEach(j -> System.out.print("*"));
            System.out.println();
        });
    }
}
