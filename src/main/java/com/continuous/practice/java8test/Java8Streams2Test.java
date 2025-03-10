package com.continuous.practice.java8test;

import com.continuous.practice.Employee;
import com.continuous.practice.EmployeeDatasource;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Java8Streams2Test {

    public static void main(String[] args) {

        List<Employee> employeeList = EmployeeDatasource.getEmployees();

//        // Query 1 : How many male and female employees are there in the organization?
//        Map<String, Long> noOfMaleAndFemaleEmployees  = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.counting()));
//        System.out.println(noOfMaleAndFemaleEmployees);
//        System.out.println("Query 2 : Print the name of all departments in the organization?");
////        employeeList.stream().distinct().forEach(System.out::println);
//        System.out.println("Query 3 : What is the average age of male and female employees?");
//        Map<String, Double> avgAge = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.averagingLong(Employee::getAge)));
//        System.out.println(avgAge);oooo
//        System.out.println("Query 4 : Get the details of highest paid employee in the organization?");
//        Optional<Employee> high = employeeList.stream().min(Comparator.comparing(Employee::getSalary));
//        System.out.println(high);
//        System.out.println("Query 5 : Get the names of all employees who have joined after 2015?");
//        employeeList.stream().filter(employee -> employee.getAge()>2015).map(employee -> employee.getName()).forEach(System.out::println);
//        System.out.println("Query 6 : Count the number of employees in each department?");
//        Map<String, Long> avgAge = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting()));
//        System.out.println(avgAge);
        System.out.println("Query 7 : What is the average salary of each department?");
        Map<String, Double> avgAge = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
        System.out.println(avgAge);
        DoubleSummaryStatistics employeeSalaryStatistics =
                employeeList.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
        employeeSalaryStatistics.getAverage();
    }
}
