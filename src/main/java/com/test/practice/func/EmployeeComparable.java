package com.test.practice.func;

import com.test.practice.Employee;
import com.test.practice.EmployeeDatasource;

public class EmployeeComparable extends Employee implements Comparable<Employee>{
    @Override
    public int compareTo(Employee e) {
        if(super.getSalary()==e.getSalary()){
            return 0;
        }
        else{
            return 1;
        }
    }

    public static void main(String[] args) {
        EmployeeComparable employeeComparable = (EmployeeComparable) EmployeeDatasource.getEmployees();

    }
}
