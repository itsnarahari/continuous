package com.test.practice.latest;

import com.test.practice.Employee;
import com.test.practice.EmployeeDatasource;

import java.util.*;
import java.util.stream.Collectors;

public class WiproQuestions {

    public static void main(String[] args) {

        List<Employee> employeeList = EmployeeDatasource.getEmployees();

        // Employee Min Salary
        System.out.println("Minimum Salary");
        employeeList.stream().min(Comparator.comparing(Employee::getSalary)).stream().forEach(employee -> System.out.println(employee));
        Employee employee1 = employeeList.stream().min(Comparator.comparing(Employee::getSalary)).get();
        // Employee Max Salary
        System.out.println("Maximum Salary");
        employeeList.stream().max(Comparator.comparing(Employee::getSalary)).stream().forEach(employee -> System.out.println(employee));

        Map<Boolean, List<Employee>> collect = employeeList.stream().collect(Collectors.partitioningBy(employee -> employee.getGender() == "male"));
        // Max Salary from each department

        System.out.println("Max Salary from each department");
        Map<String, Optional<Employee>> maxSalaryFromEachDept =
                employeeList.stream()
                        .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.maxBy(Comparator.comparing(Employee::getSalary))));

        System.out.println(maxSalaryFromEachDept);

        // Employees Working on Each Department.
        System.out.println("Employees Working on Each Department. ");
        employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.toList())).entrySet()
                .forEach(stringListEntry -> System.out.println(stringListEntry));

        // Print Count Of Each Department.
        System.out.println("Print Count Of Each Department. ");
        employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()))
                .entrySet().forEach(stringLongEntry -> System.out.println(stringLongEntry));

        // Max Salary
        System.out.println("Max salary Of the Employee");
        Double maxSalary = employeeList.stream().map(Employee::getSalary).max(Double::compare).get();
        System.out.println("Maximum Salary is " + maxSalary);

        // Min Salary
        System.out.println("Min salary Of the Employee");
        Double minSalary = employeeList.stream().map(Employee::getSalary).min(Double::compare).get();
        System.out.println("Minimum Salary is " + minSalary);

    }
}
