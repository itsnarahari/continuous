package com.test.practice.utils;

import java.util.Arrays;

public class RevArray {

    public static void main(String[] args) {

        int[] a = {12, 45, 78, 96, 35, 12, 7, 0, 23, 4};
        int n = a.length;
        int temp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (a[i] < a[j]) {
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(a));
    }
}
