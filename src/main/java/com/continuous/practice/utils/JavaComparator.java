package com.continuous.practice.utils;


import lombok.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
class Student {

    private int id;
    private String name;
    private int marks;
}

public class JavaComparator {
    public static void main(String[] args) {

        List<Student> studentList = Arrays.asList(new Student(1, "hari", 86),
                new Student(3, "sai", 46),
                new Student(2, "babu", 99),
                new Student(4, "telugu", 75),
                new Student(2, "xyz", 99)
        );

        List<Student> list = studentList.stream().sorted(Comparator.comparing(Student::getName).thenComparingInt(Student::getMarks))
                .collect(Collectors.toList());
        System.out.println(list);

        Collections.sort(studentList, Comparator.comparing(Student::getName).thenComparingInt(Student::getMarks));
//        Collections.sort(studentList,(o1, o2) -> o2.getMarks()-o1.getMarks());
        System.out.println(studentList);
    }

}
