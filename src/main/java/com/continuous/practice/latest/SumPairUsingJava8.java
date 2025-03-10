package com.continuous.practice.latest;

import java.util.stream.IntStream;

public class SumPairUsingJava8 {

    public static void main(String[] args) {

        int input[] = {3, 6, 8, 3, 9, 0};
        int sum = 54;

        IntStream.range(0, input.length)
                .forEach(i -> IntStream.range(0, input.length)
                        .filter(j -> i != j && input[i] + input[j] == sum)
                        .forEach(j -> System.out.println(input[i] + input[j]))
                );
    }
}
