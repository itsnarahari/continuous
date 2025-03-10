package com.continuous.practice.latest;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class RemoveDuplicates {

    public static void main(String[] args) {
        List<Integer> list = List.of(5, 8, 2, 5, 7, 8, 3, 6, 7);

        Map<Integer, Long> collect = list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(collect);

        // Remove duplicates
        List<Integer> collect1 = list.stream().filter(i -> Collections.frequency(list, i) > 1).collect(Collectors.toList());
        System.out.println(collect1);
    }
}
