package com.continuous.p2025;

import com.continuous.practice.Employee;
import com.continuous.practice.EmployeeDatasource;

import java.util.List;

public class StreamsApiTest2 {

    public static void main(String[] args) {
        List<Employee> employees = EmployeeDatasource.getEmployees();

    }
}
