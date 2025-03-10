package com.continuous.practice.test2;

import java.util.*;

public class ArrayDuplicates {

    public static int v = 10;
    public final int b = 20;

    public static void array_duplicates(int... arr) {

        v = 20;
        v = 50;
        System.out.println(v);
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        Map map = new HashMap();
        List list = new ArrayList();
        for (int a : arr) {
            if (map.containsKey(a)) {
                System.out.println("duplicates" + a);
            } else {
                map.put(a, a);
                list.add(a);
            }
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(list);
    }

    public static void main(String[] args) {
        int arr[] = {45, 78, 65, 96, 36, 78, 96, 1, 6, 7, 9, 3, 1};
        array_duplicates(arr);
    }
}
