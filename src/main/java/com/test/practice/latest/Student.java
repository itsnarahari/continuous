package com.test.practice.latest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter@Getter
@AllArgsConstructor
@ToString
public class Student {

    private int id;
    private String name;
    private List<Marks> marks;
}
