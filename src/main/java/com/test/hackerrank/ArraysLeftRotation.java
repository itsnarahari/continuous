package com.test.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraysLeftRotation {

    public static List<Integer> rotLeft(List<Integer> a, int d) {
        // 5 1 2 3 4
        ArrayList<Integer> arrayList = new ArrayList();
        arrayList.addAll(a);
        for (int i = 0; i < d; i++) {
            int first = arrayList.get(0);
            arrayList.remove(0);
            arrayList.add(arrayList.size(), first);
            System.out.println(arrayList);
        }
        return arrayList;

    }

    public static void main(String[] args) {
        rotLeft(Arrays.asList(1,2,3,4,5),4);
    }
}
