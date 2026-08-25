package com.continuous.p2026;

import com.continuous.practice.Employee;
import com.continuous.practice.EmployeeDatasource;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams2026 {
    public static void main(String[] args) {

        List<Employee> employees = EmployeeDatasource.getEmployees();
        List<Integer> listOfNumbers = Arrays.asList(10, 20, 400, 5, 30, 50, 3, 40, 20, 30, 300);

// 1. How many male and female employees are there in the organization?
        Map<String, Long> genderCount = employees.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        System.out.println("Gender count in an org " + genderCount);


//
// 2. Print the name of all departments in the organization?
        System.out.println("Print the name of all departments in the organization?");
        employees.forEach(employee -> System.out.println(employee.getDepartment()));
        List<String> list = employees.stream().map(Employee::getDepartment).toList();
        System.out.println(list);
//
// 3. What is the average age of male and female employees?
        Map<String, Double> averageAge = employees.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getAge)));
        System.out.println("What is the average age of male and female employees?");
        System.out.println(averageAge);
//
// 4. Get the details of highest paid employee in the organization?
        Map<String, Double> collect = employees.stream().max(Comparator.comparing(Employee::getSalary)).stream().collect(Collectors.toMap(Employee::getName, Employee::getSalary));
        System.out.println(collect);
        Optional<Employee> max = employees.stream().max(Comparator.comparingDouble(Employee::getSalary));
        System.out.println(max.get().getSalary());

//
// 5. Get the names of all employees who have joined after 2015?
        List<String> list1 = employees.stream().filter(employee -> employee.getYearOfJoining() > 2015).map(Employee::getName).toList();
        System.out.println(list1);
//
// 6. Count the number of employees in each department?
        employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting())).forEach((s, aLong) -> System.out.println(s + " ----> " + aLong));
//
// 7. What is the average salary of each department?
        Map<String, Double> collect1 = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
        System.out.println(collect1);
//
// 8. Count the number of male and female employees in each department?
        Map<String, Map<String, Long>> collect2 = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.groupingBy(Employee::getGender, Collectors.counting())));
        System.out.println(collect2);
//
// 9. Find the First Non-Repeating Character in a String (Fresher Level)
        String s = "java is tough but o, java is best";
        Character c1 = s.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting())).entrySet().stream().filter(longEntry -> longEntry.getValue() == 1).map(Map.Entry::getKey).findFirst().orElse(null);
        System.out.println(c1);
//
// 10. Find Maximum & Minimum Number in a List (Fresher Level)
        Integer i = listOfNumbers.stream().max(Comparator.comparingInt(Integer::intValue)).get();
        System.out.println(i);
        Integer i1 = listOfNumbers.stream().min(Comparator.comparingInt(Integer::intValue)).get();
        System.out.println(i1);

//
// 11. Count the Occurrences of Each Word in a List (Experienced Level)
        List<String> words = Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple");
        Map<String, Long> collect3 = words.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(collect3);

//
// 12. Find the Second-Highest Salary (Experienced Level)
        Employee employee = employees.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).distinct().skip(1).findFirst().get();
        System.out.println(employee.getSalary());
//
// 13. Find Employees with Highest Salary in Each Department (Expert Level)
        Map<String, Optional<Employee>> collect4 = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.maxBy(Comparator.comparing(Employee::getSalary))));
        System.out.println(collect4);
//
// 14. Find Employees with Second-Highest Salary in Each Department (Expert Level)
        Map<String, Employee> collect5 = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.collectingAndThen(Collectors.toList(), empList -> empList.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).skip(1).findFirst().orElseGet(null))));
        System.out.println(collect5);


//
// 15. Sort a list of employees first by department, then by salary in descending order.
        List<Employee> list2 = employees.stream().sorted(Comparator.comparing(Employee::getDepartment).thenComparing(Employee::getSalary).reversed()).toList();
        System.out.println(list2);
//
// 16. Group employees by department and calculate the average salary per department.
        Map<String, Double> map = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
        System.out.println(map);
//
// 17. Write a program to print 5 random numbers in sorted order using forEach in Java 8?
        new Random().ints(5).sorted().forEach(System.out::println);
//
// 18. Write a Java 8 program to get the sum of all numbers present in a list?
        int sum = listOfNumbers.stream().mapToInt(value -> value).sum();
        System.out.println(sum);
//
// 19. Write a Java 8 program to square the list of numbers and then filter out the numbers greater than 100 and
//        then find the average of the remaining numbers?
        OptionalDouble average = listOfNumbers.stream().map(value -> value * value).filter(value -> value > 100).mapToInt(Integer::intValue).average();
        System.out.println(average);

// 20. Given a String, find the first repeated character in it using Stream functions?
        Optional<Character> first = s.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting())).entrySet().stream().filter(characterLongEntry -> characterLongEntry.getValue() == 2).map(Map.Entry::getKey).findFirst();
        System.out.println(first);
//
// 21. Explain StringJoiner Class in Java 8? How can we achieve joining multiple Strings using StringJoiner Class?
        StringJoiner j1 = new StringJoiner(", ");
        j1.add("Java");
        j1.add("Spring");

        StringJoiner j2 = new StringJoiner(", ");
        j2.add("Kafka");
        j2.add("Redis");

        j1.merge(j2);

        String result = String.join(", ", "Java", "Spring", "Kafka");
        StringJoiner joiner = new StringJoiner(", ", "[", "]");

        joiner.add("Java");
        joiner.add("Spring");
        joiner.add("Kafka");

        List<String> names = Arrays.asList("Hari", "Ankit", "Rahul");

        String joined = names.stream().collect(Collectors.joining(", "));
        System.out.println(joined);

//
// 22. Write a Java 8 program to add prefix and suffix to the String?
        String joined2 = names.stream().collect(Collectors.joining(", ", "[", "]"));
        System.out.println(joined2);
//
// 23. Collectors partitioningBy() method in Java
        Map<Boolean, List<Integer>> collect6 = listOfNumbers.stream().collect(Collectors.partitioningBy(integer -> integer % 2 == 0));
        System.out.println(collect6);
        Map<Boolean, Double> collect7 = listOfNumbers.stream().collect(Collectors.partitioningBy(integer -> integer % 2 == 0, Collectors.averagingDouble(Integer::intValue)));
        System.out.println(collect7);

//
// 24. Write a Java 8 program to concatenate two Streams?
        Stream stream1 = Stream.of(1, 2, 3);
        Stream stream2 = Stream.of(4, 5, 6);
        Stream.concat(stream1, stream2);
        Stream.of(stream1, stream2);
//
// 25. Employee Min Salary
        Optional<Employee> min = employees.stream().min(Comparator.comparing(Employee::getSalary));
        System.out.println(min);
//
// 26. Employee Max Salary
//
// 27. Max Salary from each department
        Map<String, Optional<Employee>> collect8 = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.maxBy(Comparator.comparing(Employee::getSalary))));
        System.out.println(collect8);
//
// 28. Employees Working on Each Department.
        Map<String, List<Employee>> collect9 = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment));
        System.out.println(collect9);

//
// 29. Print Count Of Each Department.
        Map<String, Long> collect10 = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        System.out.println(collect10);
        //
// 30. Sort By using Java 8 forward and reversed
        List<String> list3 = employees.stream().sorted(Comparator.comparing(Employee::getName)).map(Employee::getName).toList();
        System.out.println(list3);
        List<String> list4 = employees.stream().sorted(Comparator.comparing(Employee::getName).reversed()).map(Employee::getName).toList();
        System.out.println(list4);
// 31. Group Each Employee By Hobbies
        Map<String, List<String>> groupedByHobby = employees.stream().flatMap(emp -> emp.getHobbies().stream().map(hobby -> Map.entry(hobby, emp.getName()))).collect(Collectors.groupingBy(Map.Entry::getKey, Collectors.mapping(Map.Entry::getValue, Collectors.toList())));
// 32. Find the second Highest number in a list.
//
// 33. Count the occurrences of each word in a list.

// 34. Remove duplicates & sort in descending order
        listOfNumbers.stream().distinct().sorted(Comparator.reverseOrder()).forEachOrdered(System.out::println);
// 35. Filter odd numbers & square them
        listOfNumbers.stream().filter(elem -> elem % 2 != 0).map(elem -> elem * elem).toList();
// 36. Find the 2nd and 3rd elements
        listOfNumbers.stream().skip(1).limit(2).toList();
// 37. Partition a list into even and odd
        Map<Boolean, List<Integer>> collect11 = listOfNumbers.stream().collect(Collectors.partitioningBy(elem -> elem % 2 != 0));
// 38. Find the employee with the highest salary
        Optional<Employee> max1 = employees.stream().max(Comparator.comparing(Employee::getSalary));
// 39. Group words by their length

// 40. Count word frequency in a list
        Map<Integer, List<String>> collect12 = words.stream().collect(Collectors.groupingBy(String::length));
// 41. Flatten a list of lists
        List<String> list5 = employees.stream().flatMap(s1 -> s1.getHobbies().stream()).distinct().toList();
        System.out.println(list5);
// 42. Find the total salary by department
        Map<String, DoubleSummaryStatistics> collect13 = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.summarizingDouble(Employee::getSalary)));
        //collect13.get("dfds").getSum();
        System.out.println(collect13);
// 43. Get the top 3 highest-paid employees
        List<Employee> list6 = employees.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).limit(3).toList();
        System.out.println(list6);
        List<Employee> list7 = employees.stream().distinct().toList();
        System.out.println(list7);
// 44. Count how many employees are in each department
        Map<String, Long> collect14 = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
// 45. Find total transaction amount per category
// 46. Find the average salary of employees in each department
        Map<String, Double> collect15 = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));

// 47. Find the highest paid employee in each department
        employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))));

        // Find the second highest paid employee in each department
        Map<String, Double> collect16 = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.collectingAndThen(Collectors.toList(), l -> l.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).distinct().skip(1).findFirst().get().getSalary())));
        System.out.println(collect16);

// 48. Convert a list of employee names into a comma-separated string
        String collect17 = employees.stream().map(employee1 -> employee1.getName()).distinct().collect(Collectors.joining(","));
        System.out.println(collect17);
// 49. Find common elements between two lists
        List<Integer> listOf1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> listOf2 = Arrays.asList(3, 4, 5, 6, 7);

        List<Integer> list8 = listOf2.stream().filter(elem -> Collections.frequency(listOf1, elem) != 0).toList();
        System.out.println(list8);
        Set<Integer> dupCheck = new HashSet<>(listOf1);
        list8 = listOf2.stream().filter(elem -> dupCheck.contains(elem)).toList();
        System.out.println(list8);
// 50. Flatten a list of lists & remove duplicates
        List<List<Integer>> lists = Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(3, 4, 5), Arrays.asList(5, 6, 7));
        List<Integer> list9 = lists.stream().flatMap(l -> l.stream()).distinct().toList();
        System.out.println(list9);
// 51. Print all employee names as fast as possible (parallel streams)
        employees.stream().parallel().distinct();
        employees.parallelStream().map(Employee::getName).forEach(System.out::println);
// 52. Spot the bug — what is wrong with this code?
// 53. Compute total salary of all employees as fast as possible
        double reduce = employees.parallelStream().mapToDouble(Employee::getSalary).sum();
        System.out.println(reduce);
        reduce = employees.parallelStream().mapToDouble(Employee::getSalary).reduce(0, (a, b) -> a + b);
        System.out.println(reduce);
        reduce = employees.parallelStream().mapToDouble(Employee::getSalary).reduce(0, Double::sum);
        System.out.println(reduce);
        System.out.printf("%.2f%n", reduce);

        BigDecimal total = employees.stream()
                .map(Employee::getSalary)
                .map(BigDecimal::valueOf)
                .peek(System.out::println)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println(total);
        System.out.println(total.setScale(2, RoundingMode.CEILING));

        // 54 anymatch, allmatch, noneMatch
        employees.stream()
                .anyMatch(e -> e.getSalary() > 100000);
        employees.stream()
                .allMatch(e -> e.getSalary() > 30000);
        employees.stream()
                .noneMatch(e -> e.getDepartment().equals("HR"));
        //55 Lazy evaluation
        // Question: Why doesn't this print anything?
        //Lazy evaluation means intermediate Stream operations are not executed immediately. They are executed only when a terminal operation is invoked.
        List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);

        Stream<Integer> stream = numbers.stream()
                .filter(n -> {
                    System.out.println("Filtering: " + n);
                    return n > 20;
                });

        System.out.println("Stream created");
        // Because there's no terminal operation.
        // Then:
        //
        //employees.stream()
        //    .filter(...)
        //    .collect(Collectors.toList());
        //
        //Now it executes.
        //
        //Understand:
        //
        //Intermediate operation
        //        ↓
        //lazy
        //
        //Terminal operation
        //        ↓
        //triggers execution
        employees.stream()
                .filter(e -> {
                    System.out.println(e.getName());
                    return e.getSalary() > 50000;
                });

        // 56: Stream cannot be reused

        Stream<String> stream3 = names.stream();
        stream3.count();
        //stream.forEach(System.out::println);
       // What happens?: IllegalStateException
        // A Stream is single-use.
        //57: Generate first 10 even numbers.
        Stream<Integer> limit = Stream.iterate(0, n -> n + 2)
                .limit(10);
        System.out.println(limit);

        //58: Generate 5 random numbers.
        Stream<Double> limit1 = Stream.generate(Math::random)
                .limit(5);
        System.out.println(limit1);
        //59: Stream sorting with multiple conditions
        Comparator<Employee> comparator =
                Comparator.comparing(Employee::getDepartment)
                        .thenComparing(
                                Employee::getSalary,
                                Comparator.reverseOrder()
                        )
                        .thenComparing(Employee::getName);
//        Find duplicate integers
//        Remove duplicates
//        Find duplicate employee IDs
//        Find employees with duplicate IDs
//        Find elements occurring exactly once
//        Find elements occurring more than once
//        Find first duplicate
//        Find first non-repeating character
//        Find frequency of each element
//        stream() vs parallelStream()
//        When is parallelStream useful?
//        When can it be slower?
//                Is ordering guaranteed?
//        findFirst vs findAny
//        forEach vs forEachOrdered
//        Is shared mutable state safe?
//                How many threads does parallelStream use?
//                Which thread pool does it use?
//        1. filter
//        2. map
//        3. flatMap
//        4. distinct
//        5. sorted
//        6. skip
//        7. limit
//        8. peek
//
//        9. collect
//        10. reduce
//        11. count
//        12. min/max
//        13. findFirst/findAny
//        14. anyMatch/allMatch/noneMatch
//        15. forEach/forEachOrdered
//
//        16. groupingBy
//        17. partitioningBy
//        18. mapping
//        19. reducing
//        20. summing*
//                21. averaging*
//                22. summarizing*
//                23. joining
//        24. counting
//        25. collectingAndThen
//        26. toMap
//
//        27. Optional
//        28. Primitive Streams
//        29. Infinite Streams
//        30. Lazy evaluation
//        31. Stream reuse
//        32. Parallel Streams
//        33. Stream ordering
//        34. Stateful vs stateless operations
//        35. Short-circuiting operations

        Map<Integer, String> collect18 = employees.stream()
                .collect(Collectors.toMap(
                        Employee::getId,
                        Employee::getName,
                        (existing, duplicate) -> existing
                ));
    //60: Get total salary paid per department
        Map<String, Double> collect19 = employees.stream()
                .collect(Collectors.toMap(
                        Employee::getDepartment,
                        Employee::getSalary,
                        Double::sum
                ));
        System.out.println(collect19);
        //61: New hashmap with supplier
        Map<Integer, String> newhashmap = employees.stream()
                .collect(Collectors.toMap(
                        Employee::getId,
                        Employee::getName,
                        (existing, duplicate) -> existing,
                        LinkedHashMap::new
                ));
        System.out.println(newhashmap);

        Map<Integer, String> newTreeMap = employees.stream()
                .collect(Collectors.toMap(
                        Employee::getId,
                        Employee::getName,
                        (existing, duplicate) -> existing,
                        TreeMap::new
                ));
        System.out.println(newTreeMap);

        // 2 parameters: toMap(keyMapper, valueMapper)

// 3 parameters: toMap(keyMapper, valueMapper, mergeFunction)

// 4 parameters: toMap(keyMapper, valueMapper, mergeFunction, mapSupplier)

        Collectors.toMap(
                Employee::getId,
                Employee::getName,
                (e1, e2) -> e1,
                LinkedHashMap::new
        );
//        Employee
//   │
//   ├── getId() ─────────→ Map KEY
//   │
//   ├── getName() ───────→ Map VALUE
//   │
//   ├── duplicate key ────→ keep first
//   │
//   └── LinkedHashMap ───→ Map implementation

        // Sort existing Map by key

        Map<Integer, String> map2 = new HashMap<>();

        map2.put(30, "Java");
        map2.put(10, "Spring");
        map2.put(20, "Kafka");
        map2.put(40, "Redis");

        Map<Integer, String> sortedMap = new TreeMap<>(map2);

        System.out.println(sortedMap);

        // Sort by key using Java 8 Streams
        Map<Integer, String> sortedMap2 = map2.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> a,
                        LinkedHashMap::new
                ));
        System.out.println(sortedMap2);
        // Descending key order
        Map<Integer, String> sortedMap3Desc = map2.entrySet()
                .stream()
                .sorted(Map.Entry.<Integer, String>comparingByKey().reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> a,
                        LinkedHashMap::new
                ));
        System.out.println(sortedMap3Desc);

        map2.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> a,
                        LinkedHashMap::new
                ));

//        Short-circuiting operations in Java 8 Streams
//
//        A short-circuiting operation is an operation that can stop processing the stream as soon as the result is known, instead of processing every element.

        // This can improve performance, especially with large collections.
        // Stops as soon as it finds one matching element.
//        anyMatch()
//        allMatch()
//        noneMatch()
//        findFirst()
//        findAny()

        // And limit() is a short-circuiting intermediate operation.

        // If you're specifically preparing Java 8, don't include this as a Java 8 operation.
        // From Java 9:
        // It stops when the predicate first becomes false.
        listOfNumbers.stream()
                .takeWhile(n -> n < 40)
                .forEach(System.out::println);
    }
}
