package com.continuous.p2025;

import com.continuous.practice.Employee;
import com.continuous.practice.EmployeeDatasource;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Setter
@Getter
@AllArgsConstructor
class Emp{
    private int id;
    private String name;

    @Override
    public boolean equals(Object o) {
        return true;
//        if (!(o instanceof Emp emp)) return false;
//        return id == emp.id && Objects.equals(name, emp.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}

public class CollectionTest {

    public static void main(String[] args) {
        String str1 = "Narahari";
        String str2 = new String("Narahari");
        System.out.println(str1.hashCode());
        System.out.println(str2.intern().hashCode());
        System.out.println(System.identityHashCode(str1));
        System.out.println(System.identityHashCode(str2));

        Set<Emp> set= new HashSet<>();
        set.add(new Emp(1,"babu"));
        set.add(new Emp(1,"babu"));
        set.add(new Emp(1,"babu"));
        System.out.println(set.size());
        Object[] obj = new Object[]{3,"dsdsgd", new CollectionTest()};
        System.out.println(obj.length);
        List<Integer> numbers = Arrays.asList(10, 20, 5, 30, 50, 40, 20,30, 300);

        List<Employee> employees = EmployeeDatasource.getEmployees();

//        1 : How many male and female employees are there in the organization?
        Map<String, Long> maleAndFemaleEmployeesCount = employees.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        System.out.println(maleAndFemaleEmployeesCount);

//        2 : Print the name of all departments in the organization?
        employees.stream().map(Employee::getDepartment).distinct().forEachOrdered(System.out::println);
//        3 : What is the average age of male and female employees?
        Map<String, Double> averageAgeOfMaleAndFemaleEmployees = employees.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getAge)));
        System.out.println(averageAgeOfMaleAndFemaleEmployees);

//        4 : Get the details of highest paid employee in the organization?
        Optional<Employee> highestPaidEmployee = employees.stream().max(Comparator.comparing(Employee::getSalary));
        System.out.println(highestPaidEmployee.map(Employee::getName));

//        5 : Get the names of all employees who have joined after 2015?
        List<String> employeesWhoJoinedAfter2015 = employees.stream()
                .filter(employee -> employee.getYearOfJoining() > 2015).map(Employee::getName).toList();
        System.out.println(employeesWhoJoinedAfter2015);
//        6 : Count the number of employees in each department?
        Map<String, Long> collect = employees
                .stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        System.out.println(collect);
//        7 : What is the average salary of each department?
        Map<String, Double> collect1 = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
        System.out.println(collect1);
//        8 : Count the number of male and female employees in each department?
        Map<String, Map<String, Long>> collect2 = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.groupingBy(Employee::getGender, Collectors.counting())));
        System.out.println(collect2);

//        9. Find the First Non-Repeating Character in a String (Fresher Level)
        String s = "java is tough but o, java is best";
        Character c1 = s.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream()
                .filter(characterLongEntry -> characterLongEntry.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
        System.out.println(c1);

//        10. Find Maximum & Minimum Number in a List (Fresher Level)
        Integer max = numbers.stream().max(Comparator.comparing(Integer::intValue)).orElse(-1);
        Integer min = numbers.stream().min(Comparator.comparing(Integer::intValue)).orElse(-1);
        System.out.println(max);
        System.out.println(min);

//        11. Count the Occurrences of Each Word in a List (Experienced Level)
        List<String> words = Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple");
        Map<String, Long> collect3 = words.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(collect3);

//        12. Find the Second-Highest Salary (Experienced Level)
        List<Integer> salaries = Arrays.asList(3000, 5000, 10000, 7000, 5000, 8000);
        Integer i = salaries.stream().sorted().skip(salaries.size() - 2).findFirst().orElse(-1);
        System.out.println(i);
        i = salaries.stream().sorted((o1, o2) -> o2-o1).limit(2).skip(1).findFirst().orElse(-1);
        System.out.println(i);
        i = salaries.stream().sorted(Comparator.comparing(Integer::intValue)).skip(salaries.size()-2).findFirst().orElse(-1);
        System.out.println(i);
        i = salaries.stream().sorted(Comparator.reverseOrder()).limit(2).skip(1).findFirst().orElse(-1);
        System.out.println(i);
        Employee employee = employees.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .limit(2)
                .skip(1)
                .findFirst()
                .orElse(null);
        System.out.println(employee.getSalary());

//        13. Find Employees with Highest Salary in Each Department (Expert Level)
        Map<String, Optional<Employee>> collect4 = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.maxBy(Comparator.comparing(Employee::getSalary))));
        System.out.println(collect4);

//        14. Find Employees with Second-Highest Salary in Each Department (Expert Level)
        Map<String, Employee> secondHighestByDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.collectingAndThen(Collectors.toList(),
                empList -> empList
                        .stream()
                        .sorted(Comparator.comparing(Employee::getSalary).reversed())
                        .skip(1)
                        .findFirst()
                        .orElse(null)
        )));
        secondHighestByDept.forEach((dept, emp) ->
                System.out.println("Department: " + dept + ", Second Highest Paid Employee: " + emp.getSalary())
        );

//        15. Sort a list of employees first by department, then by salary in descending order.
        List<Employee> list = employees.stream().sorted(Comparator.comparing(Employee::getDepartment).thenComparing(Employee::getSalary).reversed())
                .toList();
        System.out.println(list);
//        16. Group employees by department and calculate the average salary per department.
        Map<String, Double> collect5 = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
        System.out.println(collect5);

//        17. Write a program to print 5 random numbers in sorted order using forEach in Java 8?
        IntStream.rangeClosed(1, 5).sorted().forEachOrdered(System.out::print);
        System.out.println();
//        18. Write a Java 8 program to get the sum of all numbers present in a list?
        int sum = numbers.stream().mapToInt(value -> value).sum();
        System.out.println(sum);
        double sum1 = employees.stream().mapToDouble(Employee::getSalary).sum();
        System.out.println(sum1);

//        19. Write a Java 8 program to square the list of numbers
//        and then filter out the numbers greater than 100 and then find the average of the remaining numbers?
        OptionalDouble average = numbers.stream().filter(integer -> integer > 100).mapToInt(Integer::intValue).average();
        System.out.println(average.orElse(-1d));
//        20. Given a String, find the first repeated character in it using Stream functions?
        String str = "java babu";
        Character c2 = str.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(characterLongEntry -> characterLongEntry.getValue() == 1)
                .map(characterLongEntry -> characterLongEntry.getKey())
                .findFirst()
                .orElse(null);
        System.out.println(c2);

//        21. Explain StringJoiner Class in Java 8? How can we achieve joining multiple Strings using StringJoiner Class?
//                StringJoiner stj = new StringJoiner(",");
//        // Separated the elements with a comma in between.
//        stj.add("Saket");
//        stj.add("John");
//        stj.add("Franklin");
//        stj.add("Ricky");
//        stj.add("Trevor");
//        22. Write a Java 8 program to add prefix and suffix to the String?
//                StringJoiner stj2 = new StringJoiner(",", "(", ")");
//
//        // Separated the elements with a comma in between.
//        //Added a prefix "(" and a suffix ")"
//        stj2.add("Saket");
//        stj2.add("John");
//        stj2.add("Franklin");
//        stj2.add("Ricky");
//        stj2.add("Trevor");
//        23. Collectors partitioningBy() method in Java
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Map<Boolean, List<Integer>> collect6 = stream.collect(Collectors.partitioningBy(integer -> integer % 2 == 0));
        System.out.println(collect6);
//        24. Write a Java 8 program to concatenate two Streams?
        Stream stream1 = Stream.of(1,2,3);
        Stream stream2 = Stream.of(4,5,6);
        Stream.concat(stream1,stream2);
        Stream.of(stream1, stream2);

//                25. Employee Min Salary
//        26. Employee Max Salary
        Optional<Employee> max1 = employees.stream().max(Comparator.comparing(Employee::getSalary));
        System.out.println(max1);
//        27. Max Salary from each department
        Map<String, Optional<Employee>> collect7 = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.maxBy(Comparator.comparing(Employee::getSalary))));
        System.out.println(collect7);
//        28. Employees Working on Each Department.
        Map<String, List<Employee>> collect8 = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment));
        System.out.println(collect8);
//        29. Print Count Of Each Department.
        Map<String, Long> collect9 = employees
                .stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        System.out.println(collect9);
//        30. Sort By using java 8 forward and reversed
//        31. Group Each Employee By Hobbies
        // Sample employee list with multiple hobbies
        List<Employee> employeeList = Arrays.asList(
                new Employee("Alice", Arrays.asList("Reading", "Gaming")),
                new Employee("Bob", Arrays.asList("Gaming", "Swimming")),
                new Employee("Charlie", Arrays.asList("Reading", "Cooking")),
                new Employee("David", Arrays.asList("Swimming", "Cooking")),
                new Employee("Eve", Arrays.asList("Gaming", "Reading"))
        );

        Map<String, List<String>> groupedByHobby = employeeList.stream()
                .flatMap(emp -> emp.getHobbies()
                        .stream()
                        .map(hobby -> Map.entry(hobby, emp.getName())))
                .collect(Collectors.groupingBy(Map.Entry::getKey,
                        Collectors.mapping(Map.Entry::getValue, Collectors.toList())));


        System.out.println(groupedByHobby);
//        32. Find the second Highest number in a list.
        Integer i1 = numbers.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().orElse(-1);
        System.out.println("second Highest number %d".formatted(i1));

//        33. Count the occurences of each word in a list
        s.chars().mapToObj(value -> (char) value).collect(Collectors.)


    }
}
