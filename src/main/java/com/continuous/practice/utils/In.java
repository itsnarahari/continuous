package com.continuous.practice.utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.Collectors;

public class In {

    public static void main(String[] args) {
        Map<String, Integer> unsortMap = new HashMap<>();
        unsortMap.put("z", 10);
        unsortMap.put("b", 5);
        unsortMap.put("a", 6);
        unsortMap.put("c", 20);
        unsortMap.put("d", 1);
        unsortMap.put("e", 7);
        unsortMap.put("y", 8);
        unsortMap.put("n", 99);
        unsortMap.put("g", 50);
        unsortMap.put("m", 2);
        unsortMap.put("f", 9);
//        Map<String, Integer> sorted = new HashMap<>();
//        unsortMap.entrySet().stream().sorted(Map.Entry.comparingByKey())
//                .forEach(stringIntegerEntry -> sorted.put(stringIntegerEntry.getKey(),stringIntegerEntry.getValue()));

        Map<String, Integer> sorted = unsortMap.entrySet().stream().sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, HashMap::new));

        Iterator iterator = sorted.entrySet().iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
//        System.out.println(sorted);
    }
}
