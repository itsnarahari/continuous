package com.continuous.p2025;

import com.continuous.practice.Employee;
import com.continuous.practice.EmployeeDatasource;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SeptemberTest {
    public SeptemberTest(){
        System.out.println("public");
    }
    private SeptemberTest(String str){
        System.out.println("private");
    }
    public static void main(String[] args) {

//        Problem: Given a list of words, group them by their length using Java 8 Streams.
//        {3=[api], 4=[java, boot], 6=[spring], 7=[quarkus], 13=[microservices]}

        List<String> words = Arrays.asList("api", "java", "boot", "api", "spring", "spring", "microservices");

        Map<Integer, List<String>> collect = words.stream().collect(Collectors.groupingBy(string -> string.length(), Collectors.toList()));
        System.out.println(collect);

        List<Employee> employees = EmployeeDatasource.getEmployees();
        // 1. How many male and female employees are there in the organization?
        System.out.println("1. How many male and female employees are there in the organization?");
        Map<String, Long> maleAndFemales = employees.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        System.out.println(maleAndFemales);
        //2. Print the name of all departments in the organization?
        System.out.println("2. Print the name of all departments in the organization?");
        employees.stream().map(Employee::getDepartment).distinct().forEach(System.out::println);
        // 3. What is the average age of male and female employees?
        System.out.println("3. What is the average age of male and female employees?\n");
        Map<String, Double> avgAgeOfMaleAndFemale = employees.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getAge)));
        System.out.println(avgAgeOfMaleAndFemale);
//        4. Group words by their starting letter and print them (using Method References)
        System.out.println("4. Group words by their starting letter and print them (using Method References");


    }
}
