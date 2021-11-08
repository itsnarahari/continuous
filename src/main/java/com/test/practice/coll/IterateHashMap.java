package com.test.practice.coll;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class IterateHashMap {

    public static void main(String[] args) {

        Map<String, Object> map = new HashMap<>();
        map.put("one",1);
        map.put("two",2);
        map.put("three",3);
        for(Map.Entry entry:map.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
        TreeMap treeMap = new TreeMap();
        treeMap.putAll(map);
        System.out.println(treeMap);
    }
}
