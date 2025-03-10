package com.continuous.practice.java8test;

import com.continuous.practice.Employee;
import com.continuous.practice.EmployeeDatasource;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeStreamAPi {

    public static void main(String[] args) {

        List<Employee> employeeList = EmployeeDatasource.getEmployees();
//        employeeList.stream().sorted(Comparator.comparing(Employee::getName).thenComparing(Employee::getAge));
//        employeeList.stream().sorted((o1, o2) -> o2.getAge() - o1.getAge())
//                .forEach(employee -> System.out.println(employee));

        Map<String, Map<String, Long>> collect = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.groupingBy(Employee::getGender, Collectors.counting())));

        System.out.println(collect);


    }
}
