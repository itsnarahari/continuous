package com.continuous.practice.java8test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Java8Test3 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(10, 15, 8, 49, 32, 25, 98, 32, 15, 300, 99);

        //Q2 Given a list of integers, find out all the numbers starting with 1 using Stream functions?
        list.stream().map(String::valueOf).filter(s -> s.startsWith("1")).forEach(System.out::println);

        // Q3 How to find duplicate elements in a given integers list in java using Stream functions?
        System.out.println("Q3 How to find duplicate elements in a given integers list in java using Stream functions?");
        list.stream().filter(integer -> Collections.frequency(list, integer)>1).collect(Collectors.toSet()).forEach(System.out::println);

        //Q4 Given the list of integers, find the first element of the list using Stream functions?
        System.out.println("Q4 Given the list of integers, find the first element of the list using Stream functions?");
        Integer i = list.stream().findFirst().get();
        System.out.println("First Value "+ i);

        //Q5 Given a list of integers, find the total number of elements present in the list using Stream functions?
        System.out.println("Q5 Given a list of integers, find the total number of elements present in the list using Stream functions?");
        long count = list.stream().count();
        System.out.println("Count "+ count);

        //Q6 Given a list of integers, find the maximum value element present in it using Stream functions?
        System.out.println("Q6 Given a list of integers, find the maximum value element present in it using Stream functions?");
        Integer max = list.stream().max((o1, o2) -> o1 - o2).get();
        System.out.println("Max "+ max);

        //Q7 Given a String, find the first non-repeated character in it using Stream functions?
        System.out.println("Q7 Given a String, find the first non-repeated character in it using Stream functions?");

        new Random().ints(10).limit(2).sorted().forEach(System.out::println);

        list.stream().mapToInt(value -> value).sum();
    }
}
