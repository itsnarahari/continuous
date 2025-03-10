package com.continuous.p2025;

import com.continuous.practice.utils.In;

import java.util.*;

public class GroupListOfStringsFromArrayAndCount {

    int i;
    public GroupListOfStringsFromArrayAndCount(){
        System.out.println("empty cons");
    }

    public GroupListOfStringsFromArrayAndCount(int i){
        System.out.println("parameterized cons");
    }

    public static void main(String[] args) {

        GroupListOfStringsFromArrayAndCount listOfStringsFromArrayAndCount = new GroupListOfStringsFromArrayAndCount(23);

        Integer i1= Integer.valueOf(1);
        Integer i2 = Integer.valueOf(2);
        System.out.println(i1==i2);
        System.out.println(i1.equals(i2));

        String s1="hello";
        String s2=new String("hello");

        System.out.println(s1.equals(s2));
        System.out.println(s1==s2);

        Integer i=1147483647;
        System.out.println(i);

        List<String> stringList = List.of("dog", "cat", "elephant", "rabbit", "fox", "giraffe", "ant", "zebra", "owl");
        GroupListOfStringsFromArrayAndCount groupListOfStringsFromArrayAndCount = new GroupListOfStringsFromArrayAndCount();
        groupListOfStringsFromArrayAndCount.groupListOfStringsFromArrayAndCount(stringList);
    }

    public void groupListOfStringsFromArrayAndCount(List<String> stringList){
        Map<Integer, List<String>> groupsAndCountMap = new HashMap<>();

        for (String eachString: stringList){
            if(eachString!=null){
                int eachStringLength = eachString.length();
                if(groupsAndCountMap.containsKey(eachStringLength)){
                    List<String> oldStringList = groupsAndCountMap.get(eachStringLength);
                    oldStringList.add(eachString);
                    groupsAndCountMap.put(eachStringLength, oldStringList);
                }else{
                    List<String> groupedString = new ArrayList<>();
                    groupedString.add(eachString);
                    groupsAndCountMap.put(eachStringLength, groupedString);
                }
            }
        }
        System.out.println(groupsAndCountMap);
        groupsAndCountMap.entrySet().stream().forEach(integerListEntry -> {
            System.out.println(String.format("Strings of length %d: %d", integerListEntry.getKey(), integerListEntry.getValue().size()));
        });
    }
}
