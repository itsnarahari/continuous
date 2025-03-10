package com.continuous.practice.utils;

import java.util.Arrays;
import java.util.List;

public class DuplicatePrintTest {

    public static void main(String[] args) {

        int arr[] = {45, 6, 3, 4, 7, 8, 4, 5, 36, 56, 12, 83, 19, 43, 0, 12, 12};

        List list = Arrays.asList(arr);
        int newArray[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    System.out.println("Duplicate " + arr[j]);
                } else {
                    newArray[i] = arr[i];
                }
            }
        }
        System.out.println(Arrays.toString(newArray));
    }
}
