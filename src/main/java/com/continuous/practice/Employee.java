package com.continuous.practice;

import lombok.*;

import java.util.List;
import java.util.Objects;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee{

    private int id;
    private String name;
    private int age;
    private String gender;
    private String department;
    private int yearOfJoining;
    private double salary;
    private String mobile;
    private String email;
    private String modeOfContact;
    private List<String> hobbies;

    public Employee(String name, List<String> hobbies) {
        this.name=name;
        this.hobbies = hobbies;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return  id==employee.getId();
    }

    @Override
    public int hashCode() {
        return 0;
    }
}


