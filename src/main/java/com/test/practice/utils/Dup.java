package com.test.practice.utils;

import java.util.*;
import java.util.stream.Collectors;

public class Dup {

    public static void main(String[] args) {

        String str = "acs solutions is located in hyderabad. hyderabad is in india india";
        // is , in , hyderabad
        // max Number repeated max number

        String[] strArray = str.split(" ");

        Map<String, Integer> map = new HashMap<>();


        for (int i = 0; i < strArray.length; i++) {
            String s = strArray[i];
            s = s.replace(".", "");
            if (map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
            } else {
                map.put(s, 1);
            }
        }
        Map<String, Integer> map2 = new LinkedHashMap<>();

        for (Map.Entry entry : map.entrySet()) {
            int i = (int) entry.getValue();
            if (i > 1) {
                map2.put(entry.getKey().toString(), i);
            }
        }
        List<Integer> values = new ArrayList<Integer>(map2.values());

        Set<Integer> set = new HashSet<>();
        Set<Integer> collect = values.stream().filter(integer -> !set.add(integer)).collect(Collectors.toSet());
        Map.Entry<String, Integer> stringIntegerEntry;
        if (collect.size() == values.size()) {
            stringIntegerEntry = map2.entrySet().stream().sorted(Map.Entry.comparingByKey()).findFirst().get();
        } else {
            stringIntegerEntry = map2.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).findFirst().get();
        }
        System.out.println(stringIntegerEntry.getKey());

    }
}
