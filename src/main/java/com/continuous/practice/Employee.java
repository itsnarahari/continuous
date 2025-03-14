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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return getId() == employee.getId() && getAge() == employee.getAge() && getYearOfJoining() == employee.getYearOfJoining() && Double.compare(getSalary(), employee.getSalary()) == 0 && Objects.equals(getName(), employee.getName()) && Objects.equals(getGender(), employee.getGender()) && Objects.equals(getDepartment(), employee.getDepartment()) && Objects.equals(getMobile(), employee.getMobile()) && Objects.equals(getEmail(), employee.getEmail()) && Objects.equals(getModeOfContact(), employee.getModeOfContact()) && Objects.equals(getHobbies(), employee.getHobbies());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getAge(), getGender(), getDepartment(), getYearOfJoining(), getSalary(), getMobile(), getEmail(), getModeOfContact(), getHobbies());
    }
}


