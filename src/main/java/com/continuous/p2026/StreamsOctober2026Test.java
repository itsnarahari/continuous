package com.continuous.p2026;

import com.continuous.practice.Employee;
import com.continuous.practice.EmployeeDatasource;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsOctober2026Test {

    public static void main(String[] args) {
        List<Employee> employees = EmployeeDatasource.getEmployees();
        List<Integer> numbers = Arrays.asList(10, 197, 400, 147, 30, 50, 231, 40, 20, 30, 300);
        List<Integer> numbers2 = Arrays.asList(1, 58, 400, 6, 30, 50, 78, 40, 32, 9, 300);

        String str = "java is tough but o, java is best";
        List<String> words = Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple");

        List<List<Integer>> nestedList = List.of(
                List.of(1, 2, 3, 4),
                List.of(3, 4, 5, 6),
                List.of(5, 6, 7, 8)
        );
        List<Student> students = Student.getStudents();

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
        Map<String, Double> collect8 = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
//        How do you print five random numbers in sorted order using forEach?
        new Random().ints(5).sorted().forEach(System.out::println);
//        How do you calculate the sum of all numbers in a list?
        int sum = numbers.stream().mapToInt(Integer::intValue).sum();
//        How do you square numbers, filter values greater than 100, and calculate the average?
        OptionalDouble average = numbers.stream().mapToInt(integer -> integer * 2).filter(integer -> integer > 100).average();
//        How do you find the first repeated character using streams?
        Optional<Character> first = str.chars().mapToObj(value -> (char) value)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(characterLongEntry -> characterLongEntry.getValue() == 1)
                .map(characterLongEntry -> characterLongEntry.getKey())
                .findFirst();
//        How does StringJoiner work and how do you join strings with it?
        StringJoiner stringJoiner = new StringJoiner("(",")", ",");
        stringJoiner.add("abcd");

//                How do you add a prefix and suffix to a joined string?
//        How does Collectors.partitioningBy() work?
        Map<Boolean, List<Integer>> collect9 = numbers.stream().collect(Collectors.partitioningBy(integer -> integer % 2 == 0));
//        How do you concatenate two streams?
        Stream<Integer> stream1 = Stream.of(32,465);
        Stream<Integer> stream2 = Stream.of(1,2);
        Stream.of(stream1, stream2);
        Stream.concat(stream1, stream2);

//        How do you find an employee's minimum salary?
        Employee employee = employees.stream().min(Comparator.comparing(Employee::getSalary).reversed()).get();
//        How do you find an employee's maximum salary?
        Optional<Employee> max1 = employees.stream().max(Comparator.comparing(Employee::getSalary));
//        How do you find the maximum salary in each department?
        Map<String, Optional<Employee>> collect10 = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.maxBy(Comparator.comparing(Employee::getSalary))));

//        How do you list employees working in each department?
        Map<String, List<Employee>> collect11 = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.toList()));
        System.out.println(collect11);
//                How do you print the count of each department?
        Map<String, Long> collect12 = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
//                How do you sort values in forward and reversed order?
        employees.stream().sorted(Comparator.comparing(Employee::getName)).toList();
        employees.stream().sorted(Comparator.comparing(Employee::getName).reversed()).toList();
//        How do you group employees by hobbies?
        Map<String, List<String>> collect13 = employees.stream()
                .flatMap(employee1 -> employee1.getHobbies().stream().map(s -> Map.entry(s, employee1.getName())))
                .collect(Collectors.groupingBy(Map.Entry::getKey, Collectors.mapping(Map.Entry::getKey, Collectors.toList())));
//      How do you find the second-highest number in a list?
        Optional<Integer> first1 = numbers.stream().sorted(Comparator.comparing(Integer::intValue).reversed()).skip(1).limit(1).findFirst();
//        How do you remove duplicates and sort numbers in descending order?
        List<Integer> list1 = numbers.stream().filter(integer -> Collections.frequency(numbers, integer) == 1).sorted(Comparator.comparing(Integer::intValue).reversed()).toList();

//                How do you filter odd numbers and square them?
        List<Integer> list2 = numbers.stream().filter(integer -> integer % 2 != 0).map(integer -> integer * 2).toList();
//                How do you find the second and third elements using skip() and limit()?
        Integer i = numbers.stream().sorted(Comparator.comparing(Integer::intValue).reversed()).skip(1).findFirst().get();
//                How do you partition a list into even and odd numbers?
        Map<Boolean, List<Integer>> collect14 = numbers.stream().collect(Collectors.partitioningBy(integer -> integer % 2 != 0));

//                How do you group words by their length?
        Map<Integer, List<String>> collect15 = words.stream().collect(Collectors.groupingBy(s -> s.length(), Collectors.toList()));
        // Follow-up challenge: How would you group the words by length but store only the count of words for each length, using Map<Integer, Long>?
        Map<Integer, Long> collect16 = words.stream().collect(Collectors.groupingBy(s -> s.length(), Collectors.mapping(Function.identity(), Collectors.counting())));
        Map<Integer, Long> collect17 = words.stream()
                .collect(Collectors.groupingBy(
                        String::length,
                        Collectors.counting()
                ));
        System.out.println(collect17);
        //        How do you flatten a list of lists?
        employees.stream().flatMap(employee1 -> employee1.getHobbies().stream()).toList();
//        How do you find total salary by department?
        Map<String, Double> collect18 = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.summingDouble(Employee::getSalary)));

//        How do you get the top three highest-paid employees?
        List<Employee> list3 = employees.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).limit(3).toList();
//                How do you count employees in each department?
//        How do you find the total transaction amount per category?
//        How do you find the average salary in each department?
        Map<String, Double> collect19 = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
//        How do you convert employee names into a comma-separated string?
        String collect20 = employees.stream().map(Employee::getName).collect(Collectors.joining(","));
//                How do you find common elements between two lists?
        numbers.stream().filter(integer -> Collections.frequency(numbers2, integer)>0).toList();
        List<Integer> common = numbers.stream()
                .filter(numbers2::contains)
                .toList();
//                How do you flatten nested lists and remove duplicates?
        List<Integer> list4 = nestedList.stream().flatMap(nested -> nested.stream()).distinct().toList();
//                How do you print employee names using a parallel stream?
        List<Employee> list5 = employees.parallelStream().distinct().toList();
//        How do you calculate total salary using a parallel stream?
        employees.parallelStream().mapToDouble(Employee::getSalary).sum();
//        What is wrong with a given stream program, and how do you identify the bug?
//        Stream API and Collectors concepts
//        How do you find duplicate integers?
        numbers.stream().filter(integer -> Collections.frequency(numbers, integer)>1).toList();
//        How do you remove duplicate elements?
//        How do you find duplicate employee IDs?
        employees.stream().collect(Collectors.groupingBy(Employee::getId, Collectors.counting()))
                .entrySet()
                .stream().filter(integerLongEntry -> integerLongEntry.getValue()>1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
//        How do you find elements occurring exactly once?
//        How do you find elements occurring more than once?
//                How do you find the first duplicate?
//                How do you find the frequency of each element?
//                What is the difference between stream() and parallelStream()?
//                When is parallelStream() useful?
//                When can a parallel stream be slower?
//        Is ordering guaranteed in a stream? Ans: No
//        Is shared mutable state safe in stream operations?
        // No. Shared mutable state is generally not safe in parallel Stream operations unless you handle concurrency correctly.
        List<Integer> result = new ArrayList<>();

        numbers.parallelStream()
                .forEach(result::add);

        System.out.println(result.size());
//        Problem: Multiple threads call result.add() concurrently. ArrayList is not thread-safe, so this can cause data races, lost updates, or other unexpected behavior.
        Set<Integer> result2 = ConcurrentHashMap.<Integer>newKeySet();

        numbers.parallelStream()
                .forEach(result2::add);
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
        List<Student> list6 = students.stream().filter(student -> {
            OptionalDouble average1 = student.getMarks().stream().mapToInt(Integer::intValue).average();
            return average1.getAsDouble() >= 80;
        }).toList();

        List<Student> result24 = students.stream()
                .filter(student -> student.getMarks().stream()
                        .mapToInt(Integer::intValue)
                        .average()
                        .orElse(0) > 80)
                .toList();
//        Find the student with the highest average marks.
//        Find the student with the lowest average marks.
//        Find the total marks of each student.
        Map<String, Integer> collect21 = students.stream().collect(Collectors.toMap(Student::getName, student ->
                student.getMarks().stream().mapToInt(Integer::intValue).sum()
        ));
//                Find the average marks of each student.
        Map<String, OptionalDouble> collect22 = students.stream()
                .collect(Collectors.toMap(Student::getName, student -> student.getMarks().stream().mapToInt(Integer::intValue).average()));

//        Sort students by average marks.
        List<Student> list7 = students.stream()
                .sorted(Comparator.comparing(student -> student.getMarks().stream().mapToInt(Integer::intValue)
                        .average().orElse(0)
        )).toList();
        System.out.println(list7);
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
