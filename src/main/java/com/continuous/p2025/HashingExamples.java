package com.continuous.p2025;

import com.continuous.practice.Employee;

import java.util.*;

public class HashingExamples {

    public static void main(String[] args) {

        Map<Employee, String> map=new HashMap<>();
        Employee employee = new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0, "9908506952", "itsnarahari@gmail.com", "email", List.of("reading","cycling","coding"));
        map.put(employee, "Hari");
        employee.setId(323);
        System.out.println(map.get(employee));

        Set<Employee> set=new HashSet<>();
        Employee employee2 = new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0, "9908506952", "itsnarahari@gmail.com", "email", List.of("reading","cycling","coding"));
        set.add(employee);
        set.add(employee2);
        System.out.println(set.size());
    }
}
