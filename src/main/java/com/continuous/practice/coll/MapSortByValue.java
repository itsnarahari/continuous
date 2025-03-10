package com.continuous.practice.coll;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class MapSortByValue {

    public static void main(String[] args) {

        Map<String, Object> map = new HashMap<>();
        map.put("three", 1);
        map.put("one", 3);
        map.put("two", 2);
        Map<String, Object> result = map.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        System.out.println(result);
    }
}
