package com.test.practice.java8test;

import java.util.ArrayList;
import java.util.List;

public class EmployeeStreamAPi {

    public static void main(String[] args) {

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
        employeeList.stream().sorted((o1, o2) -> o2.getAge()-o1.getAge())
                .forEach(employee -> System.out.println(employee));

    }
}
