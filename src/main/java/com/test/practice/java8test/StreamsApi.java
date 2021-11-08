package com.test.practice.java8test;

import java.util.*;
import java.util.stream.Collectors;

public class StreamsApi {

    public static void employeeCondition(List<Employee> employeeList) {
        employeeList.stream().filter(employee -> employee.getAge() > 20)
                .forEach(employee -> System.out.println(employee.getName()));

        long count = employeeList.stream().filter(employee -> employee.getAge() > 25).count();
        System.out.println(count);

        // Employee name with babu.
        Optional optional =  employeeList.stream().filter(employee -> employee.getName()
                .equalsIgnoreCase("babu2"))
                .findAny();
        System.out.println(optional.orElse("Not found"));

        // Given a list of employee, find maximum age of employee?
        OptionalInt maxAge = employeeList.stream()
                .mapToInt(Employee::getAge)
                .max();
        System.out.println(maxAge.orElse(0));

        // Given a list of employees, sort all the employee on the basis of age? Use java 8 APIs only

        employeeList.sort((e1,e2)->e1.getAge()-e2.getAge());
        employeeList.forEach(System.out::println);

        // Join the all employee names with “,” using java 8?
        List<String> list = employeeList.stream().map(employee -> employee.getName())
                .collect(Collectors.toList());
        System.out.println(String.join(",",list));

        // Given the list of employee, group them by employee name?
        Map<String, List<Employee>> map  = employeeList.stream().collect(Collectors.groupingBy(Employee::getName));
        System.out.println(map);

        // Given the list of numbers, remove the duplicate elements from the list.
        Integer[] arr=new Integer[]{1,2,3,4,3,2,4,2};
        Arrays.stream(arr).collect(Collectors.toSet()).forEach(integer -> System.out.println(integer));

        // Given a list of numbers, square them and filter the numbers
        // which are greater 10000 and then find average of them.( Java 8 APIs only)
        Integer[] arrList =new Integer[]{1000,2,300,4,3,2,4,2};
        OptionalDouble optionalDouble = Arrays.stream(arr)
                .mapToInt(integer -> integer*integer)
                .filter(integer -> integer>10000)
                .average();
        System.out.println(optionalDouble.orElse(0));

    }

    public static void main(String[] args) {
        List<Employee> list = new ArrayList();

        employeeCondition(list);

    }
}
