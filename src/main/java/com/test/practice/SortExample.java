package com.test.practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SortExample {

    public static void main(String[] args) {

        //Today is a beautiful day
        // a beautiful day is today

        String str = "today is a beautiful day";
        String[] s = str.split(" ");
        String collect = Arrays.stream(s).sorted().collect(Collectors.joining(" "));
        System.out.println(collect);

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (map.containsKey(str.charAt(i))) {
                map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
            } else {
                map.put(str.charAt(i), 1);
            }
        }
        System.out.println(map);
    }
}
