package com.continuous.p2025;

import com.continuous.practice.Employee;
import com.continuous.practice.EmployeeDatasource;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

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
//        7 : What is the average salary of each department?
//        8 : Count the number of male and female employees in each department?
//        9. Find the First Non-Repeating Character in a String (Fresher Level)
//        10. Find Maximum & Minimum Number in a List (Fresher Level)
//        11. Count the Occurrences of Each Word in a List (Experienced Level)
//        12. Find the Second-Highest Salary (Experienced Level)
//        List<Integer> salaries = Arrays.asList(3000, 5000, 10000, 7000, 5000, 8000);
//        13. Find Employees with Highest Salary in Each Department (Expert Level)
//        14. Find Employees with Second Highest Salary in Each Department (Expert Level)
//        15. Sort a list of employees first by department, then by salary in descending order.
//        16. Group employees by department and calculate the average salary per department.
//        17. Write a program to print 5 random numbers in sorted order using forEach in Java 8?
//        18. Write a Java 8 program to get the sum of all numbers present in a list?
//        19. Write a Java 8 program to square the list of numbers and then filter out the numbers greater than 100 and then find the average of the remaining numbers?
//        20. Given a String, find the first repeated character in it using Stream functions?
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
//        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
//        24. Write a Java 8 program to concatenate two Streams?
//                25. Employee Min Salary
//        26. Employee Max Salary
//        27. Max Salary from each department
//        28. Employees Working on Each Department.
//        29. Print Count Of Each Department.
//        30. Sort By using java 8 forward and reversed
    }
}
