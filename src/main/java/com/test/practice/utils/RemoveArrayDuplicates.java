package com.test.practice.utils;

import java.util.*;

public class RemoveArrayDuplicates {

    public static List<Integer> removeDuplicates(List<Integer> list){
        List<Integer> newList = new ArrayList<>();
        for (int value:list) {
            if(newList.contains(value)){
                continue;
            }
            else{
                newList.add(value);
            }
        }
        return newList;

    }
    public static void main(String[] args) {
        List<Integer> list = List.of(4,6,2,8,4,8,2,4,0,5,9);

        list.stream().filter(integer -> Collections.frequency(list,integer)>1).forEach(System.out::println);
        System.out.println(removeDuplicates(list));
    }
}
