package com.test.practice.func;

import com.test.practice.Employee;
import com.test.practice.EmployeeDatasource;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EmployeeComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee e1, Employee e2) {

        if (e2.getName() == e1.getName()) {
            if (e2.getAge() == e1.getAge()) {
                return 0;
            }
        } else {
            return -1;
        }
        return 0;
    }

    public static void main(String[] args) {

        List<Employee> employeeList = EmployeeDatasource.getEmployees();
        Collections.sort(employeeList, new EmployeeComparator());
        System.out.println(employeeList);
    }
}
