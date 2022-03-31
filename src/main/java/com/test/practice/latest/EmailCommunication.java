package com.test.practice.latest;

import com.test.practice.Employee;

public class EmailCommunication implements Communication{
    @Override
    public void notify(Employee employee) {

        System.out.println("EmailCommunication "+employee.getEmail());

    }
}
