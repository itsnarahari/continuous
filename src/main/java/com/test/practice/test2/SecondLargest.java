package com.test.practice.test2;

import java.util.Arrays;
import java.util.Comparator;

public class SecondLargest {

    public static void main(String[] args) {

        Integer int1 = new Integer(9);
        Integer int2 = new Integer(9);
        Integer int3 = int1;
        int i = 32;
        int i2 = 32;

        System.out.println(int1 == int2);
        System.out.println(int1.equals(int2));
        System.out.println(i == i2);

        int arr[] = {45, 78, 65, 96, 36, 1, 6, 7, 9, 3, 1};

        int asInt = Arrays.stream(arr)
                .boxed()
                .sorted(Comparator.reverseOrder()) // just use 'sorted()' for ascending order
                .mapToInt(Integer::intValue)
                .skip(1)
                .findFirst().getAsInt();

        System.out.println("second value " + asInt);

        int[] sortedArray = Arrays.stream(arr)
                .boxed()
                .sorted(Comparator.reverseOrder()) // just use 'sorted()' for ascending order
                .mapToInt(Integer::intValue)
                .toArray();

        System.out.println(Arrays.toString(sortedArray));
        Arrays.stream(arr).sorted().limit(arr.length - 1).skip(arr.length - 2).forEach(value -> System.out.println(value));
    }
}
