package com.continuous.practice.test2.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RemoveDuplicatesFromList {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("ab");
        list.add("cd");
        list.add("ab");
        list.add("ef");

        List<String> collect = list.stream().filter(s -> list.contains(s)).collect(Collectors.toList());
        System.out.println(collect);

    }
}
