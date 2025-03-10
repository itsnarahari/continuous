package com.continuous.practice.latest;

import com.continuous.practice.Employee;
import com.continuous.practice.EmployeeDatasource;

import java.util.List;

public class FactoryDesignPatternRunner {

    public static void main(String[] args) {
        List<Employee> employeeList = EmployeeDatasource.getEmployees();
        String str = "dfs";
        str.charAt(4);
        for (Employee emp : employeeList) {
            Communication instance = CommunicationFactoryBuilder.getInstance(emp);
            instance.notify(emp);
        }
    }
}
