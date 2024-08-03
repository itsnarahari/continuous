package com.test.practice;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee {

    private int id;
    private String name;
    int age;
    String gender;
    String department;
    int yearOfJoining;
    double salary;
    String mobile;
    String email;
    String modeOfContact;
}


