package com.test.practice.latest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMapExample {

    public static void main(String[] args) {

        Marks marks = new Marks(56, 78);
        Marks marks2 = new Marks(78, 68);
        Marks marks3 = new Marks(90, 95);
        Marks marks4 = new Marks(92, 98);

        List list = new ArrayList();
        list.add(marks);
        list.add(marks2);

        List list2 = new ArrayList();
        list2.add(marks3);
        list2.add(marks4);

        Student student = new Student(2, "hari", list);
        Student student2 = new Student(6, "Babu", list2);
        List<Student> students = List.of(student, student2);
        System.out.println(students);

    }
}
