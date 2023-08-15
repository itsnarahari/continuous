package com.test.practice.utils;

import java.util.Comparator;
import java.util.stream.Stream;

public class FactorialTest {


    public static int fact(int n) {

        if (n > 0) {
            return n * fact(n - 1);
        }
        return 0;
    }

    public static void main(String[] args) {
        Integer highest = Stream.of(1, 2, 3, 77, 6, 5)
                .min(Comparator.comparing(Integer::valueOf))
                .get();
        System.out.println(highest);

    }

}
