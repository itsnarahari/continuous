package com.test.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayManipulation {
    public static long arrayManipulation(int n, List<List<Integer>> queries) {
        List<Integer> list = new ArrayList<>(10);

        for (List<Integer> innerList:queries) {
            System.out.println(innerList.get(0));
            for (int i = 0; i < innerList.size(); i++) {
            }
        }
        return 0;

    }

    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1,5,3);
        List<Integer> list2 = Arrays.asList(4,8,7);
        List<Integer> list3 = Arrays.asList(6,9,1);
        List<List<Integer>> mainArray = new ArrayList<>();
        mainArray.add(list1);
        mainArray.add(list2);
        mainArray.add(list3);
        arrayManipulation(10, mainArray);
    }
}