package com.test2;

import lombok.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee {
    private int id;
    private String name;
    private int age;
    private String gender;
    private String department;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}

class Main{
    public static void main(String[] args) {
        Set<Employee> employees = new HashSet<>();
        employees.add(new Employee(111, "Naresh", 32, "Male", "HR"));
        employees.add(new Employee(111, "Sneha", 26, "Female", "HR"));
        employees.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing"));
        employees.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure"));
        employees.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure"));
        System.out.println(employees.size());
    }
}
