package com.test.online;

import java.util.Arrays;

public class Test {

    public static void main(String[] args) {

        int arr[] = {5, 10, 2, 7, 6, 1, 8};
        int asInt = Arrays.stream(arr).max().getAsInt();
        Arrays.stream(arr).filter(i -> i % 2 != 0).forEach(value -> System.out.print(value + ","));
        System.out.println();
        System.out.println(asInt);
    }
}
