package com.continuous.practice.test2;

import java.util.Arrays;

public class ArrayTwoMaximumNumbersFromArray {

    public static void main(String[] args) {

        int arr[] = {45, 78, 65, 96, 36, 1, 6, 7, 9, 3};

        // Ascending
        Arrays.stream(arr).boxed().sorted().skip(arr.length - 2).forEach(value -> System.out.println(value));

        // Descending
        Arrays.stream(arr).boxed().sorted((o1, o2) -> o2 - o1).skip(arr.length - 2).forEach(value -> System.out.println(value));

    }
}
