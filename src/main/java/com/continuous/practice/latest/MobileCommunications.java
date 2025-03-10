package com.continuous.practice.latest;

import com.continuous.practice.Employee;

public class MobileCommunications implements Communication {
    @Override
    public void notify(Employee employee) {

        System.out.println("MobileCommunications " + employee.getMobile());

    }
}
