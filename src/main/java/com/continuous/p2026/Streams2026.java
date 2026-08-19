package com.continuous.p2026;

import com.continuous.practice.Employee;
import com.continuous.practice.EmployeeDatasource;

import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams2026 {
    public static void main(String[] args) {

        List<Employee> employees = EmployeeDatasource.getEmployees();
        List<Integer> listOfNumbers = Arrays.asList(10, 20, 400, 5, 30, 50,3, 40, 20,30, 300);

//        1. How many male and female employees are there in the organization?
        Map<String, Long> genderCount = employees.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        System.out.println("Gender count in an org " + genderCount);


//
//        2. Print the name of all departments in the organization?
        System.out.println("Print the name of all departments in the organization?");
        employees.forEach(employee -> System.out.println(employee.getDepartment()));
        List<String> list = employees.stream().map(Employee::getDepartment).toList();
        System.out.println(list);
//
//        3. What is the average age of male and female employees?
        Map<String, Double> averageAge = employees.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getAge)));
        System.out.println("What is the average age of male and female employees?");
        System.out.println(averageAge);
//
//        4. Get the details of highest paid employee in the organization?
        Map<String, Double> collect = employees.stream().max(Comparator.comparing(Employee::getSalary))
                .stream().collect(Collectors.toMap(Employee::getName, Employee::getSalary));
        System.out.println(collect);
        Optional<Employee> max = employees.stream().max(Comparator.comparingDouble(Employee::getSalary));
        System.out.println(max.get().getSalary());

//
//        5. Get the names of all employees who have joined after 2015?
        List<String> list1 = employees.stream().filter(employee -> employee.getYearOfJoining() > 2015).map(Employee::getName).toList();
        System.out.println(list1);
//
//        6. Count the number of employees in each department?
        employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()))
                .forEach((s, aLong) -> System.out.println(s + " ----> " + aLong));
//
//        7. What is the average salary of each department?
        Map<String, Double> collect1 = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
        System.out.println(collect1);
//
//        8. Count the number of male and female employees in each department?
        Map<String, Map<String, Long>> collect2 = employees.stream().collect(Collectors
                .groupingBy(Employee::getDepartment, Collectors.groupingBy(Employee::getGender, Collectors.counting())));
        System.out.println(collect2);
//
//        9. Find the First Non-Repeating Character in a String (Fresher Level)
        String s = "java is tough but o, java is best";
        Character c1 = s.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(longEntry -> longEntry.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
        System.out.println(c1);
//
//        10. Find Maximum & Minimum Number in a List (Fresher Level)
        Integer i = listOfNumbers.stream().max(Comparator.comparingInt(Integer::intValue)).get();
        System.out.println(i);
        Integer i1 = listOfNumbers.stream().min(Comparator.comparingInt(Integer::intValue)).get();
        System.out.println(i1);

//
//        11. Count the Occurrences of Each Word in a List (Experienced Level)
        List<String> words = Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple");
        Map<String, Long> collect3 = words.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(collect3);

//
//        12. Find the Second-Highest Salary (Experienced Level)
        Employee employee = employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .distinct().skip(1).findFirst().get();
        System.out.println(employee.getSalary());
//
//        13. Find Employees with Highest Salary in Each Department (Expert Level)
        Map<String, Optional<Employee>> collect4 = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.maxBy(Comparator.comparing(Employee::getSalary))));
        System.out.println(collect4);
//
//        14. Find Employees with Second-Highest Salary in Each Department (Expert Level)
        Map<String, Employee> collect5 = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.collectingAndThen(Collectors.toList(),
                        empList -> empList
                                .stream()
                                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                                .skip(1).findFirst()
                                .orElseGet(null))));
        System.out.println(collect5);


//
//        15. Sort a list of employees first by department, then by salary in descending order.
        List<Employee> list2 = employees.stream()
                .sorted(Comparator.comparing(Employee::getDepartment)
                        .thenComparing(Employee::getSalary)
                        .reversed())
                .toList();
        System.out.println(list2);
//
//        16. Group employees by department and calculate the average salary per department.
        Map<String, Double> map = employees.stream()
                .collect(Collectors
                        .groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
        System.out.println(map);
//
//        17. Write a program to print 5 random numbers in sorted order using forEach in Java 8?
        new Random().ints(5).sorted().forEach(System.out::println);
//
//        18. Write a Java 8 program to get the sum of all numbers present in a list?
        int sum = listOfNumbers.stream().mapToInt(value -> value).sum();
        System.out.println(sum);
//
//        19. Write a Java 8 program to square the list of numbers and then filter out the numbers greater than 100 and
//        then find the average of the remaining numbers?
        OptionalDouble average = listOfNumbers
                .stream()
                .map(value -> value * value)
                .filter(value -> value > 100)
                .mapToInt(Integer::intValue)
                .average();
        System.out.println(average);

//                20. Given a String, find the first repeated character in it using Stream functions?
        Optional<Character> first = s.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(characterLongEntry -> characterLongEntry.getValue() == 2)
                .map(Map.Entry::getKey)
                .findFirst();
        System.out.println(first);
//
//                21. Explain StringJoiner Class in Java 8? How can we achieve joining multiple Strings using StringJoiner Class?
        StringJoiner j1 = new StringJoiner(", ");
        j1.add("Java");
        j1.add("Spring");

        StringJoiner j2 = new StringJoiner(", ");
        j2.add("Kafka");
        j2.add("Redis");

        j1.merge(j2);

        String result =
                String.join(", ", "Java", "Spring", "Kafka");
        StringJoiner joiner =
                new StringJoiner(", ", "[", "]");

        joiner.add("Java");
        joiner.add("Spring");
        joiner.add("Kafka");

        List<String> names =
                Arrays.asList("Hari", "Ankit", "Rahul");

        String joined = names.stream()
                .collect(Collectors.joining(", "));
        System.out.println(joined);

//
//      22. Write a Java 8 program to add prefix and suffix to the String?
        String joined2 = names.stream()
                .collect(Collectors.joining(", ", "[", "]"));
        System.out.println(joined2);
//
//      23. Collectors partitioningBy() method in Java
        Map<Boolean, List<Integer>> collect6 = listOfNumbers.stream().collect(Collectors.partitioningBy(integer -> integer % 2 == 0));
        System.out.println(collect6);
        Map<Boolean, Double> collect7 = listOfNumbers.stream().collect(Collectors.partitioningBy(integer -> integer % 2 == 0,
                Collectors.averagingDouble(Integer::intValue)));
        System.out.println(collect7);

//
//      24. Write a Java 8 program to concatenate two Streams?
        Stream stream1 = Stream.of(1,2,3);
        Stream stream2 = Stream.of(4,5,6);
        Stream.concat(stream1,stream2);
        Stream.of(stream1, stream2);
//
//                25. Employee Min Salary
        Optional<Employee> min = employees.stream().min(Comparator.comparing(Employee::getSalary));
        System.out.println(min);
//
//        26. Employee Max Salary
//
//        27. Max Salary from each department
        Map<String, Optional<Employee>> collect8 = employees.stream()
                .collect(Collectors
                        .groupingBy(Employee::getDepartment, Collectors.maxBy(Comparator
                                .comparing(Employee::getSalary))));
        System.out.println(collect8);
//
//        28. Employees Working on Each Department.
        Map<String, List<Employee>> collect9 = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment));
        System.out.println(collect9);

//
//        29. Print Count Of Each Department.
        Map<String, Long> collect10 = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        System.out.println(collect10);
        //
//        30. Sort By using Java 8 forward and reversed
        List<String> list3 = employees.stream().sorted(Comparator.comparing(Employee::getName)).map(Employee::getName).toList();
        System.out.println(list3);
        List<String> list4 = employees.stream().sorted(Comparator.comparing(Employee::getName).reversed()).map(Employee::getName).toList();
        System.out.println(list4);
//        31. Group Each Employee By Hobbies
        Map<String, List<String>> groupedByHobby = employees.stream()
                .flatMap(emp -> emp.getHobbies()
                        .stream()
                        .map(hobby -> Map.entry(hobby, emp.getName())))
                .collect(Collectors.groupingBy(Map.Entry::getKey,
                        Collectors.mapping(Map.Entry::getValue, Collectors.toList())));
        employees.stream().sorted(Comparator.comparing(Employee::getName)).toList();
        List<Employee> sortedEmployees = employees.stream()
                .sorted(Comparator.comparing(Employee::getName).reversed())
                .collect(Collectors.toList());

        employees.sort(
                Comparator.comparing(Employee::getName)
        );

//        32. Find the second Highest number in a list.
//
//        33. Count the occurrences of each word in a list.

        //34 reduces
        // 1. Without identity: returns Optional
        Optional<Integer> sum1 = listOfNumbers.stream()
                .reduce((a, b) -> a + b);
        System.out.println(sum1);

        // 2. With identity: returns plain value
        Integer sum2 = listOfNumbers.stream()
                .reduce(1, Integer::sum);
        System.out.println(sum2);

        // 3. With identity + accumulator + combiner
        Integer sum3 = listOfNumbers.stream()
                .reduce(2, Integer::sum, (integer, integer2) -> integer-integer2);
        System.out.println(sum3);
        boolean b = listOfNumbers.stream().anyMatch(integer -> integer == 400);
        System.out.println(b);
        boolean b1 = listOfNumbers.stream().allMatch(integer -> integer > 1);
        System.out.println(b1);
        boolean b2 = listOfNumbers.stream().noneMatch(integer -> integer > 1000);
        System.out.println(b2);
    }
}
