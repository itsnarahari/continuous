package com.continuous.practice.latest;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {


    public static Integer add(int add) {
        return 0;
    }

    public static Integer add(int add, int b) {
        return 0;
    }

    public static Integer getActualVAlues(String str) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('C', 100);
        char[] strCharArray = str.toCharArray();
        int result = 0;

        for (int i = 0; i < strCharArray.length; i++) {
            if (i > 0 && map.get(strCharArray[i]) > map.get(strCharArray[i - 1])) {
                result += map.get(strCharArray[i]) - 2 * map.get(strCharArray[i - 1]);
            } else {
                result += map.get(strCharArray[i]);
            }
            System.out.println("result " + result);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(getActualVAlues("IXX"));
        String s1 = "Hello";
        String s2 = "Hello2";
        s1 = s2;
        Integer i = null;
        System.out.println(s1);
        String.valueOf(i);
        System.out.println(i);
        i.toString();

        char[] c = {'A', 'B'};
        String str = String.valueOf(c);
        String str2 = new String(c);
    }
}
