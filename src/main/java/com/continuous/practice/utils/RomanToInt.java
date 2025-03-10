package com.continuous.practice.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RomanToInt {

    public int romanToInt(String roman) {

        /*
        - Construct Map for roman
        - To convert to array
        - loop through array
        - first check in map if i found get that value and put it in array
        - check if the i is greater than previous index or value then minus i-prev_i and
          remove prev_i and place these new value
        - Finally add those value
        - and see the response.
        - let's start
         */

        Map<Character, Integer> romanMap = new HashMap<>();

        char charArray[] = roman.toCharArray();
        List list = new ArrayList();
        for (char c : charArray)

            list.add(romanMap.get(c));


        return 0;
    }

    public static void main(String[] args) {

    }
}
