package com.continuous.practice;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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
    @NotBlank
    private String name;
    @NotBlank
    private int age;
    @Size(min = 2, max = 4)
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
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;

        Employee e = (Employee) o;
        return id == e.id;
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}


