package com.test.practice.java8test;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class JavaHashMapSortByKey {

    public static void main(String[] args) {
        Map<Integer, String> m = new HashMap<>();
        m.put(11, "audi");
        m.put(null, null);
        m.put(11, "bmw");
        m.put(null, "fer");
        System.out.println(m.size());
        System.out.println(m);
        System.out.println(m.get(null));

        Map<String, Integer> map = new HashMap<>();

        map.put("e", 5);
        map.put("b", 2);
        map.put("d", 4);
        map.put("a", 1);
        map.put("a", 5);
        map.put("c", 3);

        Map<Function<Object, Object>, Long> collect = map.entrySet().stream().collect(Collectors.groupingBy(stringIntegerEntry -> Function.identity(), Collectors.counting()));

//        System.out.println(collect);
//        map.entrySet().stream().sorted(Map.Entry.comparingByValue())
//                .forEachOrdered(stringIntegerEntry -> System.out.println(stringIntegerEntry.getKey()
//                +" "+stringIntegerEntry.getValue()));
//
//        map.entrySet().stream().sorted(Map.Entry.comparingByKey())
//                .forEach(stringIntegerEntry -> System.out.println(stringIntegerEntry.getKey()
//                        +" "+stringIntegerEntry.getValue()));
    }
}
