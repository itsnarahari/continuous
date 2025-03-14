package com.continuous.p2025;

import com.continuous.practice.Employee;
import com.continuous.practice.EmployeeDatasource;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsApiTest {

    public static void main(String[] args) {

        List<Employee> employees = EmployeeDatasource.getEmployees();

//        // Query 1 : How many male and female employees are there in the organization?
        Map<String, Long> collect = employees.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        System.out.println(collect);
//        System.out.println("Query 2 : Print the name of all departments in the organization?");
//        employees.stream().map(Employee::getDepartment).forEach(System.out::println);
//        System.out.println("Query 3 : What is the average age f male and female employees?");
        Map<String, Double> collect1 = employees.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getAge)));
        System.out.println(collect1);
//        System.out.println("Query 4 : Get the details of highest paid employee in the organization?");
        Optional<Double> v = employees.stream().max(Comparator.comparing(Employee::getSalary)).map(Employee::getSalary);
        System.out.println(v.orElse(-1.00));
//        System.out.println("Query 5 : Get the names of all employees who have joined after 2015?");
//        employees.stream().filter(employee -> employee.getYearOfJoining() > 2015).forEach(System.out::println);

//        System.out.println("Query 6 : Count the number of employees in each department?");
//        Map<String, Long> collect2 = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
//        System.out.println(collect2);
//        System.out.println("Query 7 : What is the average salary of each department?");
//        Map<String, Double> collect3 = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
//        System.out.println(collect3);

        //        System.out.println("Query 8 : Count the number of male and female employees in each department?");
//        Map<String, Map<String, Long>> collect4 = employees.stream()
//                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.groupingBy(Employee::getGender, Collectors.counting())));
//        System.out.println(collect4);
//        System.out.println("9. Find the First Non-Repeating Character in a String (Fresher Level)");
//        String input = "swiss";
//        Character c1 = input.chars()
//                .mapToObj(c -> (char) c)
//                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
//                .entrySet().stream().filter(integerLongEntry -> integerLongEntry.getValue() == 1)
//                .map(Map.Entry::getKey)
//                .findFirst()
//                .orElse(null);
//
//        System.out.println(c1);

        System.out.println("10. Find Maximum & Minimum Number in a List (Fresher Level)");
        List<Integer> numbers = Arrays.asList(10, 20, 5, 30, 50, 40);
        Integer i = numbers.stream().max(Comparator.comparingInt(Integer::intValue)).orElse(-1);
        System.out.println(i);
        Integer min = numbers.stream().min(Comparator.comparingInt(Integer::intValue)).orElse(-1);
        System.out.println(min);

        System.out.println("11. Count the Occurrences of Each Word in a List (Experienced Level)");
        List<String> words = Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple");

        Map<String, Long> collect2 = words.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(collect2);

        System.out.println("12. Find the Second-Highest Salary (Experienced Level)");
        Optional<Employee> first = employees.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).skip(1).limit(1).findFirst();
        System.out.println(first.orElse(null));

        List<Integer> salaries = Arrays.asList(3000, 5000, 10000, 7000, 5000, 8000);
        Integer i1 = salaries.stream().sorted(Comparator.comparing(Integer::intValue).reversed()).skip(1).limit(1).findFirst().orElse(null);
        System.out.println(i1);

        System.out.println("13. Find Employees with Highest Salary in Each Department (Expert Level)");

        employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.maxBy(Comparator.comparing(Employee::getSalary))))
                .entrySet()
                .forEach(stringOptionalEntry -> System.out.println(stringOptionalEntry.getKey()+" "+stringOptionalEntry.getValue().get().getSalary()));

        System.out.println("14. Find Employees with Second Highest Salary in Each Department (Expert Level)");

        // Group by department and find second highest salary employee in each
        Map<String, Optional<Employee>> secondHighestByDept = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                empList -> empList.stream()
                                        .sorted(Comparator.comparingDouble(Employee::getSalary).reversed()) // Sort Desc
                                        .skip(1) // Skip highest salary
                                        .findFirst() // Get second highest
                        )
                ));

        // Print result
        secondHighestByDept.forEach((dept, emp) ->
                System.out.println("Department: " + dept + ", Second Highest Paid Employee: " + emp.orElse(null).getSalary())
        );

        System.out.println("15. Sort a list of employees first by department, then by salary in descending order.\n");
        List<Employee> collect3 = employees.stream()
                .sorted(Comparator.comparing(Employee::getDepartment).thenComparing(Employee::getSalary).reversed())
                .collect(Collectors.toList());
        System.out.println(collect3);

        System.out.println("16. Group employees by department and calculate the average salary per department.\n");
        Map<String, Double> collect4 = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
        System.out.println(collect4);

        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

        Stream<String> nameStream = names.stream(); // Creating a stream

        // First terminal operation (Allowed)
        nameStream.forEach(System.out::println);

        // Second terminal operation (Fails ❌)
//        nameStream.forEach(System.out::println); // Exception here

        List<String> list=List.of();
        list.stream().collect(Collectors.toList());
        List<String> list1 = Optional.ofNullable(list).orElse(Collections.emptyList());
        System.out.println(list1);

        String str="Java is good and Java is powerful";
        List<String> uniqueWords = Arrays.stream(str.split(" ")).distinct().collect(Collectors.toList());
        System.out.println(uniqueWords);


        // Measure execution time for Streams
        long start1 = System.nanoTime();
        List<String> streamNames = employees.stream()
                .map(Employee::getName)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
        long end1 = System.nanoTime();
        System.out.println("Streams Execution Time: " + (end1 - start1) / 1_000_000 + " ms");

        // Measure execution time for For-Loop
        long start2 = System.nanoTime();
        List<String> loopNames = new ArrayList<>();
        for (Employee employee : employees) {
            String name = employee.getName();
            if (name != null) {
                loopNames.add(name);
            }
        }
        long end2 = System.nanoTime();
        System.out.println("For-Loop Execution Time: " + (end2 - start2) / 1_000_000 + " ms");

        employees.stream().map(Employee::getName).filter(Objects::nonNull);

        System.out.println("Q #19) Write a program to print 5 random numbers in sorted order using forEach in Java 8?\n");
        new Random().ints().limit(5).sorted().forEach(System.out::println);

        System.out.println("Q #21) Write a Java 8 program to get the sum of all numbers present in a list?\n" +
                "\n");
        List<Integer> list2=new ArrayList<>();
        list2.add(10);
        list2.add(20);
        list2.add(300);
        list2.add(40);
        list2.add(50);
        int sum = list2.stream().mapToInt(Integer::intValue).sum();
        System.out.println(sum);

        //Write a Java 8 program to square the list of numbers and then filter out the numbers greater than 100 and then find the average of the remaining numbers?
        System.out.println("Write a Java 8 program to square the list of numbers and then filter out the numbers greater than 100 and then find the average of the remaining numbers?");
        OptionalDouble average = list2.stream().mapToInt(value -> value * 2).filter(value -> value > 100).average();
        System.out.println(average.orElse(-1));

        //Write a Java 8 program to find the number of Strings in a list whose length is greater than 5?
        List<String> strings=List.of("manam","babu mahi","ujhy");
        long count = strings.stream().filter(s -> s.length() > 5).count();
        System.out.println(count);

        //Write a Java 8 program to remove the duplicate elements from the list?
        Integer[] arr1 = new Integer[] { 1, 9, 8, 7, 7, 8, 9 };
        List<Integer> collect5 = List.of(arr1).stream().filter(integer -> Collections.frequency(List.of(arr1), integer)<1).collect(Collectors.toList());
        System.out.println(collect5);

        // Group employees by hobby
        // Grouping employees by each hobby
        Map<String, List<String>> groupedByHobby = employees.stream()
                .flatMap(emp -> emp.getHobbies().stream().map(hobby -> Map.entry(hobby, emp.getName())))
                .collect(Collectors.groupingBy(Map.Entry::getKey,
                        Collectors.mapping(Map.Entry::getValue, Collectors.toList())));
        System.out.println(groupedByHobby);

        Map<String, List<String>> collect6 = employees.stream()
                .flatMap(emp -> emp.getHobbies().stream().map(hobby -> Map.entry(hobby, emp.getName())))
                .collect(Collectors.groupingBy(Map.Entry::getKey,
                        Collectors.mapping(Map.Entry::getValue, Collectors.toList())))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        System.out.println(collect6);
    }

}
