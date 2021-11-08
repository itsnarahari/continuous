package com.test.practice.java8test;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee {
    int id;
    String name;
    int age;
    String gender;

    String department;

    int yearOfJoining;

    double salary;

}


