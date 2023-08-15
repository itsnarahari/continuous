package com.test.practice;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Test {

    public static boolean checkForFaulty(String str) {

        boolean status = true;

        String dict[] = {"help", "action", "work", "accept"};

        for (int i = 0; i < dict.length; i++) {
            if (dict[i].equalsIgnoreCase(str)) {
                status = false;
                break;
            }
        }

//        Map<Character,Integer> map = new HashMap<>();
//
//        for(int i=0;i<str.length();i++){
//            if(map.containsKey(str.charAt(i))){
//                map.put(str.charAt(i),map.get(str.charAt(i))+1);
//                status=true;
//            }
//            else{
//                map.put(str.charAt(i),1);
//            }
//        }
        return status;
    }

    public static void main(String[] args) {
        boolean status = checkForFaulty("help");
        System.out.println(status);

        Map<String, String> map = new HashMap<>();
        map.put("1", "def");
        map.put("2", "abc");
        map.put("3", "ab");

        LinkedHashMap<String, String> collect = map.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getValue))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (s, s2) -> s, LinkedHashMap::new));

        System.out.println(collect);
    }
}
