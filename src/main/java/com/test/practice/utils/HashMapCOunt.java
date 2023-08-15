package com.test.practice.utils;

import java.util.HashMap;
import java.util.Map;

public class HashMapCOunt {

    public static void charCounter(String str) {

    }

    public static void main(String[] args) {
        String str = "This is it";
        str = str.replace(" ", "");
        char c[] = str.toCharArray();
        Map<Character, Integer> map = new HashMap();
        for (int i = 0; i < c.length; i++) {
            if (map.containsKey(c[i])) {
                map.put(c[i], map.get(c[i]) + 1);
            } else {
                map.put(c[i], 1);
            }
        }
        System.out.println(map);
    }
}
