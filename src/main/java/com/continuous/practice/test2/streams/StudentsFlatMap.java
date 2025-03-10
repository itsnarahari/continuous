package com.continuous.practice.test2.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StudentsFlatMap {

    public static void main(String[] args) {
        List<Subjects> subjects = new ArrayList<>();
        List<Subjects> subjects2 = new ArrayList<>();

        subjects.add(new Subjects(70, 82, 84));
        subjects2.add(new Subjects(97, 90, 88));

        List<Student> students = new ArrayList<>();
        students.add(new Student("Hari", new ArrayList<Integer>(), subjects));
        students.add(new Student("Babu", new ArrayList<Integer>(), subjects2));

        List<Subjects> collect = students.stream().map(student -> student.getSubjects()).flatMap(subjects1 -> subjects1.stream()
                        .filter(subjects3 -> subjects3.getMaths() > 80 && subjects3.getEnglish() > 80))
                .collect(Collectors.toList());


    }
}
