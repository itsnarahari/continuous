package com.continuous.p2026;

import com.continuous.practice.Employee;
import com.continuous.practice.EmployeeDatasource;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsOctober2026Test {

    public static void main(String[] args) {
        List<Employee> employees = EmployeeDatasource.getEmployees();
        List<Integer> numbers = Arrays.asList(10, 20, 400, 5, 30, 50, 3, 40, 20, 30, 300);
        String str = "java is tough but o, java is best";
        List<String> words = Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple");

//        How many male and female employees are in the organization?
        Map<String, Long> collect = employees.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        System.out.println(collect);
//        How do you print all department names?
        employees.stream().map(Employee::getDepartment).forEach(System.out::println);
//       What is the average age of male and female employees?
        Map<String, Double> collect1 = employees.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getAge)));
        System.out.println(collect1);
//        How do you find the highest-paid employee?
        Optional<Employee> maxEmployee = employees.stream().max(Comparator.comparing(Employee::getSalary));
        System.out.println(maxEmployee);
//        How do you find employees who joined after 2015?
        List<Employee> employees1 = employees.stream().filter(employee -> employee.getYearOfJoining()>2015).toList();
        System.out.println(employees1);
//        How many employees are in each department?
        Map<String, Long> collect2 = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        System.out.println(collect2);
//        What is the average salary of each department?
        Map<String, Double> collect3 = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
        System.out.println(collect3);
//        How many male and female employees are in each department?
        Map<String, Map<String, Long>> emp = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.groupingBy(Employee::getGender, Collectors.counting())));
        System.out.println(emp);
        //        How do you find the first non-repeating character in a string?
        Character c1 = str.chars().mapToObj((c -> (char) c))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().filter(characterLongEntry -> characterLongEntry.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
        System.out.println(c1);

//        How do you find the maximum and minimum number in a list?
        Integer max = numbers.stream().max(Integer::compareTo).orElse(-1);
        System.out.println(max);
        Integer min = numbers.stream().min(Integer::compareTo).orElse(-1);
        System.out.println(min);
//        How do you count occurrences of each word in a list?
        Map<String, Long> collect4 = words.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(collect4);

//                How do you find the second-highest salary?
        List<Employee> list = employees.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).skip(1).limit(1).toList();
        System.out.println(list);
//                How do you find the highest-paid employee in each department?
        Map<String, Optional<Employee>> collect5 = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))));
        System.out.println(collect5);
        // How do you find the lowest-paid employee in each department?
        Map<String, Optional<Employee>> collect6 = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.minBy(Comparator.comparingDouble(Employee::getSalary))));
        System.out.println(collect6);
//        How do you find the second-highest salary in each department?
        Map<String, Employee> collect7 = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.collectingAndThen(Collectors.toList(), empl -> empl.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).skip(1).findFirst().orElse(null))));
        System.out.println(collect7);
//        How do you sort employees by department and then salary descending?
        Stream<Employee> sorted = employees.stream().sorted(Comparator.comparing(Employee::getDepartment).thenComparing(Employee::getSalary));
        System.out.println(sorted);
//        How do you group employees by department and calculate average salary?
//        How do you print five random numbers in sorted order using forEach?
//        How do you calculate the sum of all numbers in a list?
//        How do you square numbers, filter values greater than 100, and calculate the average?
//                How do you find the first repeated character using streams?
//        How does StringJoiner work and how do you join strings with it?
//                How do you add a prefix and suffix to a joined string?
//        How does Collectors.partitioningBy() work?
//                How do you concatenate two streams?
//        How do you find an employee's minimum salary?
//        How do you find an employee's maximum salary?
//        How do you find the maximum salary in each department?
//        How do you list employees working in each department?
//                How do you print the count of each department?
//                How do you sort values in forward and reversed order?
//        How do you group employees by hobbies?
//                How do you find the second-highest number in a list?
//        How do you remove duplicates and sort numbers in descending order?
//                How do you filter odd numbers and square them?
//                How do you find the second and third elements using skip() and limit()?
//                How do you partition a list into even and odd numbers?
//                How do you group words by their length?
//        How do you flatten a list of lists?
//        How do you find total salary by department?
//        How do you get the top three highest-paid employees?
//                How do you count employees in each department?
//        How do you find the total transaction amount per category?
//        How do you find the average salary in each department?
//        How do you convert employee names into a comma-separated string?
//                How do you find common elements between two lists?
//                How do you flatten nested lists and remove duplicates?
//                How do you print employee names using a parallel stream?
//        How do you calculate total salary using a parallel stream?
//        What is wrong with a given stream program, and how do you identify the bug?
//        Stream API and Collectors concepts
//        How do you find duplicate integers?
//        How do you remove duplicate elements?
//        How do you find duplicate employee IDs?
//                How do you find employees with duplicate IDs?
//        How do you find elements occurring exactly once?
//        How do you find elements occurring more than once?
//                How do you find the first duplicate?
//                How do you find the frequency of each element?
//                What is the difference between stream() and parallelStream()?
//                When is parallelStream() useful?
//                When can a parallel stream be slower?
//        Is ordering guaranteed in a stream?
//        Is shared mutable state safe in stream operations?
//        How many threads does parallelStream() use?
//                Which thread pool does parallelStream() use?
//                What are the uses of filter, map, flatMap, distinct, sorted, skip, and limit?
//                What are the uses of collect, reduce, count, min, max, findFirst, and findAny?
//                How do anyMatch, allMatch, and noneMatch work?
//        How do forEach and forEachOrdered differ?
//        How do groupingBy, partitioningBy, mapping, and reducing work?
//        When do you use summing, averaging, summarizing, joining, and counting?
//                How does collectingAndThen work?
//                How does Collectors.toMap() handle duplicate keys?
//                What are the two-, three-, and four-argument toMap() overloads?
//                How do you provide LinkedHashMap or TreeMap as a map supplier?
//                How do you sort an existing map by key in ascending and descending order?
//        What is an Optional and how is it used with streams?
//                What are primitive streams and why use IntStream, LongStream, or DoubleStream?
//                How do infinite streams work with iterate() and generate()?
//                What is lazy evaluation in streams?
//                Why can a stream not be reused after a terminal operation?
//        What is stream ordering?
//        What is the difference between stateless and stateful stream operations?
//        What are short-circuiting stream operations?
//        What is the difference between findFirst() and findAny()?
//                How do you generate the first ten even numbers using Stream.iterate()?
//                How do you generate five random values using Stream.generate()?
//                How do you sort employees by multiple conditions?
//        Student stream practice from the source file
//        Find students whose average marks are greater than 80.
//        Find the student with the highest average marks.
//        Find the student with the lowest average marks.
//        Find the total marks of each student.
//                Find the average marks of each student.
//        Sort students by average marks.
//                Find the top three students by average marks.
//                Find students who scored above 90 in any subject.
//                Find students who scored above 80 in every subject.
//                Find the maximum mark across all students.
//        Find the minimum mark across all students.
//                Flatten all student marks into one list.
//        Find the student with the highest individual mark.
//        Group students by grade based on their average marks.
//                Other coding exercise present in Streams2026.java
//        How do you reverse the first K elements of a queue using a stack?
    }
}
