package com.test.practice.latest;

import com.test.practice.Employee;

public class CommunicationFactoryBuilder {

    public static Communication getInstance(Employee employee) {

        if (employee.getModeOfContact().equalsIgnoreCase("mobile")) {
            return new MobileCommunications();
        } else if (employee.getModeOfContact().equalsIgnoreCase("email")) {
            return new EmailCommunication();
        } else {
            return null;
        }

    }
}
