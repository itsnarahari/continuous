package com.test.practice.utils;

import java.util.Arrays;
import java.util.OptionalDouble;

public class RemoveDuplicatesWithJava8 {

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{100, 24, 13, 44, 114, 200, 40, 112};
        OptionalDouble optionalDouble = Arrays.stream(arr).mapToInt(n -> n * n).filter(n -> n > 10000).average();
        System.out.println(optionalDouble.getAsDouble());
    }
}
