package com.continuous.p2026;

import java.util.Arrays;
import java.util.List;

public class Student {

    private int id;
    private String name;
    private List<Integer> marks;

    public Student(int id, String name, List<Integer> marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Integer> getMarks() {
        return marks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", marks=" + marks +
                '}';
    }

    public static List<Student> getStudents() {

        return Arrays.asList(
                new Student(101, "Rahul", Arrays.asList(85, 90, 78, 92, 88)),
                new Student(102, "Priya", Arrays.asList(95, 89, 91, 87, 94)),
                new Student(103, "Arjun", Arrays.asList(70, 75, 68, 72, 80)),
                new Student(104, "Sneha", Arrays.asList(88, 92, 85, 90, 87)),
                new Student(105, "Vikram", Arrays.asList(60, 65, 72, 68, 70)),
                new Student(106, "Anjali", Arrays.asList(92, 96, 89, 94, 91)),
                new Student(107, "Kiran", Arrays.asList(78, 82, 75, 80, 77)),
                new Student(108, "Meena", Arrays.asList(65, 70, 68, 74, 72)),
                new Student(109, "Rohit", Arrays.asList(90, 85, 88, 93, 89)),
                new Student(110, "Pooja", Arrays.asList(82, 79, 85, 88, 84))
        );
    }
}
