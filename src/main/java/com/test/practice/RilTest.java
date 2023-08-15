package com.test.practice;

import com.test.practice.Employee;
import com.test.practice.EmployeeDatasource;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RilTest {

    public static void main(String[] args) {

        //  arraylist with 5 objects where each objects are employee object
        // name, age

        List<Employee> sortedEmployees = getSortedEmployees(EmployeeDatasource.getEmployees());
        System.out.println(sortedEmployees);

    }

    public static List<Employee> getSortedEmployees(List<Employee> employees) {
        try {
            if (employees.size() > 0) {
                List<Employee> sortedEmployees = employees.stream()
                        .sorted(Comparator.comparing(Employee::getAge))
                        .collect(Collectors.toList());
                return sortedEmployees;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return new ArrayList<>();
    }
}
