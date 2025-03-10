package com.continuous.practice.test2.streams;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Student {

    private String name;
    private List<Integer> marks;
    private List<Subjects> subjects;
}
