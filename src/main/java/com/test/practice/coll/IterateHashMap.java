package com.test.practice.coll;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.TreeMap;

public class IterateHashMap {

    public static void main(String[] args) {

        Map<String, Object> map = new HashMap<>();
        Hashtable hashtable = new Hashtable();
        hashtable.put(null, "sdsad");
        map.put(null, "dsadas");
        map.put(null, "abcd");
        System.out.println(map.get(null));

//        map.put("one",1);
//        map.put("two",2);
//        map.put("three",3);
//        for(Map.Entry<String, Object> entry:map.entrySet()){
//            System.out.println(entry.getKey()+" "+entry.getValue());
//        }
//        TreeMap treeMap = new TreeMap();
//        treeMap.putAll(map);
//        System.out.println(treeMap);
    }
}
