package com.continuous.practice.utils;

import java.util.Arrays;

public class SecondLargestNumberTest {

    public static void main(String[] args) {
        int arr[] = {45, 6, 3, 4, 7, 8, 4, 5, 36, 56, 12, 83, 19, 43, 0};
        System.out.println(Arrays.stream(arr).max());
        int first = 0;
        int second = 0;
        for (int obj : arr) {
            if (first < obj) {
                second = first;
                first = obj;
            } else if (second < obj) {
                second = obj;
            }
        }
        System.out.println(first);
        System.out.println(second);
    }
}
