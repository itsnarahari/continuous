package com.continuous.practice.java8test;

import com.continuous.practice.Employee;
import com.continuous.practice.EmployeeDatasource;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8StreamTest2 {

    final String str = "sda";

    public static void main(String[] args) {

//        Hashtable hashtable=new Hashtable();
//        hashtable.put(null,"null");
//        Map treeMap=new TreeMap();
//        treeMap.put("null",null);
//        Set set=new TreeSet();
//        set.add(null);

        List<Integer> list = Arrays.asList(10, 15, 8, 49, 32, 25, 98, 32, 15, 300, 99);
        //Q1 Given a list of integers, find out all the even numbers exist in the list using Stream functions?
        System.out.println("Q1 Given a list of integers, find out all the even numbers exist in the list using Stream functions?");
        list.stream().filter(integer -> integer % 2 == 0).forEach(System.out::println);

        //Q2 Given a list of integers, find out all the numbers starting with 1 using Stream functions?
        System.out.println("Q2 Given a list of integers, find out all the numbers starting with 1 using Stream functions?");
        list.stream().map(integer -> integer + "").filter(s -> s.startsWith("1")).forEach(System.out::println);

        // Q3 How to find duplicate elements in a given integers list in java using Stream functions?
        System.out.println("Q3 How to find duplicate elements in a given integers list in java using Stream functions?");
        list.stream().filter(integer -> Collections.frequency(list, integer) > 1).collect(Collectors.toSet()).forEach(System.out::println);

        //Q4 Given the list of integers, find the first element of the list using Stream functions?
        System.out.println("Q4 Given the list of integers, find the first element of the list using Stream functions?");
        Integer integer = list.stream().findFirst().get();
        System.out.println(integer);

        //Q5 Given a list of integers, find the total number of elements present in the list using Stream functions?
        System.out.println("Q5 Given a list of integers, find the total number of elements present in the list using Stream functions?");
        long count = list.stream().count();
        System.out.println(count);

        //Q6 Given a list of integers, find the maximum value element present in it using Stream functions?
        System.out.println("Q6 Given a list of integers, find the maximum value element present in it using Stream functions?");
        Integer integer1 = list.stream().max(Comparator.comparing(Integer::intValue)).get();
        Integer integer2 = list.stream().sorted((o1, o2) -> o2 - o1).findFirst().get();
        System.out.println(integer1);
        System.out.println(integer2);

        //Q7 Given a String, find the first non-repeated character in it using Stream functions?
        System.out.println("Q7 Given a String, find the first non-repeated character in it using Stream functions?");

        //Q8 Given a String, find the first repeated character in it using Stream functions?
        System.out.println("Q8 Given a String, find the first repeated character in it using Stream functions?");
        String input = "Java Hungry Blog Alive is Awesome";
        String s = Arrays.stream(input.split(""))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().filter(stringLongEntry -> stringLongEntry.getValue() > 1L)
                .map(Map.Entry::getKey).findFirst().get();
        System.out.println(s);

        //Q9 Given a list of integers, sort all the values present in it using Stream functions?
        System.out.println("Q9 Given a list of integers, sort all the values present in it using Stream functions?");
        List<Integer> collect = list.stream().sorted().collect(Collectors.toList());
        System.out.println(collect);

        //Q10 Given a list of integers, sort all the values present in it in descending order using Stream functions?
        System.out.println("Q10 Given a list of integers, sort all the values present in it in descending order using Stream functions?");
        List<Integer> collect1 = list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(collect1);

        List<Integer> collect2 = list.stream().sorted((o1, o2) -> o2 - o1).collect(Collectors.toList());
        System.out.println(collect2);
        String.valueOf(3.5);

        //Q #19) Write a program to print 5 random numbers in sorted order using forEach in Java 8?
        System.out.println("Q #19) Write a program to print 5 random numbers in sorted order using forEach in Java 8?\n" +
                "\n");

        new Random().ints(5).sorted().forEach(System.out::println);
        new Random().ints(10).limit(2).sorted().forEach(System.out::println);

        //Q #21) Write a Java 8 program to get the sum of all numbers present in a list?
        System.out.println("Q #21) Write a Java 8 program to get the sum of all numbers present in a list?");
        int sum = list.stream().mapToInt(value -> value).sum();
        System.out.println(sum);

        //Q #22) Write a Java 8 program to square the list of numbers and then filter out the numbers greater than 100 and then find the average of the remaining numbers?
        System.out.println("Q #22) Write a Java 8 program to square the list of numbers and then filter out the numbers greater than 100 and then find the average of the remaining numbers?");
        int i1 = list.stream().map(i -> i * 2).filter(i -> i > 100).collect(Collectors.averagingDouble(Integer::intValue)).intValue();

        System.out.println("i111111 " + i1);
        //Q #28) Write a Java 8 program to find the lowest and highest number of a Stream?
        System.out.println("Q #28) Write a Java 8 program to find the lowest and highest number of a Stream?");
        Integer lowest = list.stream().min(Comparator.comparing(Integer::intValue)).get();
        System.out.println(lowest);

        Integer highest = list.stream().max(Comparator.comparing(Integer::intValue)).get();
        System.out.println(highest);

        //Q #34) Explain StringJoiner Class in Java 8? How can we achieve joining multiple Strings using StringJoiner Class?
        System.out.println("Q #34) Explain StringJoiner Class in Java 8? How can we achieve joining multiple Strings using StringJoiner Class?");
        StringJoiner stj = new StringJoiner("=");
        // Separated the elements with a comma in between.

        stj.add("Saket");
        stj.add("John");
        stj.add("Franklin");
        stj.add("Ricky");
        stj.add("Trevor");

        // Added elements into StringJoiner “stj
        System.out.println(stj);

        //Q #35) Write a Java 8 program to add prefix and suffix to the String?
        System.out.println("Q #35) Write a Java 8 program to add prefix and suffix to the String?");
        StringJoiner stj2 = new StringJoiner(",", "(", ")");

        // Separated the elements with a comma in between.
        //Added a prefix "(" and a suffix ")"
        stj2.add("Saket");
        stj2.add("John");
        stj2.add("Franklin");
        stj2.add("Ricky");
        stj2.add("Trevor");
        // Added elements into StringJoiner “stj”
        System.out.println(stj2);

        List<Employee> employeeList = EmployeeDatasource.getEmployees();

        // Query 1 : How many male and female employees are there in the organization?
        System.out.println("Query 1 : How many male and female employees are there in the organization?");
        Map<String, Long> collect3 = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        System.out.println(collect3);

        System.out.println("Query 2 : Print the name of all departments in the organization?");

        employeeList.stream().map(Employee::getDepartment).forEach(System.out::println);
        employeeList.stream().map(Employee::getDepartment).collect(Collectors.toSet()).forEach(System.out::println);

        System.out.println("Query 3 : What is the average age of male and female employees?");
        Map<String, Double> avgAgeOfMaleAndFemale = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getAge)));
        System.out.println(avgAgeOfMaleAndFemale);

        System.out.println("Query 4 : Get the details of highest paid employee in the organization?");
        Employee employee = employeeList.stream().max(Comparator.comparing(Employee::getSalary)).get();
        System.out.println(employee);

        System.out.println("Query 4 : Get the details of lowest paid employee in the organization?");
        Employee employee1 = employeeList.stream().min(Comparator.comparing(Employee::getSalary)).get();
        System.out.println(employee1);

        System.out.println("Query 5 : Get the names of all employees who have joined after 2015?");
        List<Employee> collect4 = employeeList.stream().filter(employee2 -> employee2.getYearOfJoining() > 2015).collect(Collectors.toList());
        System.out.println(collect4);

        System.out.println("Query 6 : Count the number of employees in each department?");
        Map<String, Long> collect5 = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        System.out.println(collect5);

        System.out.println("Query 7 : What is the average salary of each department?");
        Map<String, Double> collect6 = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
        System.out.println(collect6);

        System.out.println("Map sort by value");
        Map<String, Object> map = new HashMap<>();
        map.put("three", 1);
        map.put("one", 3);
        map.put("two", 2);
        LinkedHashMap<String, Object> collect7 = map.entrySet().stream().sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        System.out.println(collect7);

        System.out.println("Q #39) Write a Java 8 program to concatenate two Streams?");
        List<String> list1 = Arrays.asList("Java", "8");
        List<String> list2 = Arrays.asList("explained", "through", "programs");
        Stream<String> concat = Stream.concat(list1.stream(), list2.stream());
        Stream.of(concat, concat);
        System.out.println(concat);

        System.out.println("Collectors partitioningBy() method in Java");
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Map<Boolean, List<Integer>> collect8 = stream.collect(Collectors.partitioningBy(integer3 -> integer3 > 3));
        System.out.println(collect8);

        // Given a list of numbers, square them and filter the numbers
        // which are greater 10000 and then find average of them.( Java 8 APIs only)
        Integer[] arrList = new Integer[]{1000, 2, 300, 4, 30000, 2, 4, 2};
        OptionalDouble average = Arrays.stream(arrList).mapToInt(i -> i * 2).filter(i -> i > 10000).average();
        System.out.println(average);

    }

    public void m1() {
    }
}
