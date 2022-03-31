package com.test.practice.latest;

import com.test.practice.Employee;

public class MobileCommunications implements Communication{
    @Override
    public void notify(Employee employee) {

        System.out.println("MobileCommunications "+employee.getMobile());

    }
}
