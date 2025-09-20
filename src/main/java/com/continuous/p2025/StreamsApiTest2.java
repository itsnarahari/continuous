package com.continuous.p2025;

import com.continuous.practice.Employee;
import com.continuous.practice.EmployeeDatasource;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamsApiTest2 {

    public static void main(String[] args) {
        List<Employee> employees = EmployeeDatasource.getEmployees();

//        11. Find the first repeated character in a string using Java 8 Streams
        System.out.println("11. Find the first repeated character in a string using Java 8 Streams");
        String str = "java babu";
        Character c2 = str.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(characterLongEntry -> characterLongEntry.getValue()>1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
        System.out.println(c2);
//        12. Find the longest word in a given sentence using Java 8 Streams
        System.out.println("12. Find the longest word in a given sentence using Java 8 Streams\n");
        String sentence="Find the longest word in a given sente using Java 8 Streams";

        int length = Arrays.stream(sentence.split(" ")).mapToInt(String::length).max().orElse(0);
        String s = Arrays.stream(sentence.split(" ")).filter(string -> string.length() == length).findFirst().orElse(null);
        System.out.println(s);
        Map<String, Long> collect = Arrays.stream(sentence.split(" ")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(collect);

//        13. Given a list of employees with name,
//        department, and salary, find the highest-paid employee in each department using Java 8 Streams.

        System.out.println("13. Given a list of employees with name, department, and salary, find the highest-paid employee in each department using Java 8 Streams.\n");
        Map<String, Optional<Employee>> collect1 = employees.stream()
                .collect(Collectors
                        .groupingBy(Employee::getDepartment, Collectors
                                .maxBy(Comparator.comparing(Employee::getSalary))));
        System.out.println(collect1);

        Map<String, String> collect2 = employees.stream()
                .collect(Collectors
                        .groupingBy(Employee::getDepartment, Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(Employee::getSalary)),
                                opt -> opt.map(Employee::getName).orElse(null))));
        System.out.println(collect2);
//        14. Given a list of sentences, find the Top 3 most frequent words using Java 8 Streams.
        System.out.println("14. Given a list of sentences, find the Top 3 most frequent words using Java 8 Streams.\n");
//        17. Given a list of integers, find the second highest number using Java 8 Stream API.
        System.out.println("17. Given a list of integers, find the second highest number using Java 8 Stream API.");
        List<Integer> numbers = Arrays.asList(10, 20, 5, 30, 50, 40, 43, 20,30);

        // ASC
        Integer i = numbers.stream().sorted().skip(numbers.size() - 2).findFirst().orElse(null);

        Integer i2 = numbers.stream().sorted((o1, o2) -> o2-o1).limit(2).skip(1).findFirst().orElse(null);
        System.out.println(i);
        System.out.println(i2);

//        18. Find the first non-repeated character in a string using Java 8 Stream API
        System.out.println("18. Find the first non-repeated character in a string using Java 8 Stream API");
        String character = "character";

        Character c1 = character.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream()
                .filter(characterLongEntry -> characterLongEntry.getValue() == 1)
                .map(characterLongEntry -> characterLongEntry.getKey())
                .findFirst().orElse(null);
        System.out.println(c1);


    }
}
