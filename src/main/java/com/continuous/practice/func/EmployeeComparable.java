package com.continuous.practice.func;

import com.continuous.practice.Employee;
import com.continuous.practice.EmployeeDatasource;

public class EmployeeComparable extends Employee implements Comparable<Employee> {
    @Override
    public int compareTo(Employee e) {
        if (super.getSalary() == e.getSalary()) {
            return 0;
        } else {
            return 1;
        }
    }

    public static void main(String[] args) {
        EmployeeComparable employeeComparable = (EmployeeComparable) EmployeeDatasource.getEmployees();

    }
}
