package com.continuous.practice.latest;

import com.continuous.practice.Employee;

public class EmailCommunication implements Communication {
    @Override
    public void notify(Employee employee) {

        System.out.println("EmailCommunication " + employee.getEmail());

    }
}
