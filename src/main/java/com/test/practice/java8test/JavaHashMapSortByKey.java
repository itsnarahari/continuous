package com.test.practice.java8test;

import java.util.HashMap;
import java.util.Map;

public class JavaHashMapSortByKey {

    public static void main(String[] args) {

        Map<String,Integer> map = new HashMap<>();

        map.put("e",5);
        map.put("b",2);
        map.put("d",4);
        map.put("a",1);
        map.put("c",3);

        map.entrySet().stream().sorted(Map.Entry.comparingByValue())
                .forEachOrdered(stringIntegerEntry -> System.out.println(stringIntegerEntry.getKey()
                +" "+stringIntegerEntry.getValue()));

        map.entrySet().stream().sorted(Map.Entry.comparingByKey())
                .forEach(stringIntegerEntry -> System.out.println(stringIntegerEntry.getKey()
                        +" "+stringIntegerEntry.getValue()));
    }
}
