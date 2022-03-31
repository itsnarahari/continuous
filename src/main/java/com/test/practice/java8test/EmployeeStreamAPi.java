package com.test.practice.java8test;

import com.test.practice.Employee;
import com.test.practice.EmployeeDatasource;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class EmployeeStreamAPi {

    public static void main(String[] args) {

        List<Employee> employeeList = EmployeeDatasource.getEmployees();
        employeeList.stream().sorted(Comparator.comparing(Employee::getName).thenComparing(Employee::getAge));
        employeeList.stream().sorted((o1, o2) -> o2.getAge()-o1.getAge())
                .forEach(employee -> System.out.println(employee));

    }
}
