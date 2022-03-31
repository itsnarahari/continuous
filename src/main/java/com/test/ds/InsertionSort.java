package com.test.ds;

import java.util.Arrays;

public class InsertionSort {

    public static int[] sort(int arr[]) {
        int key = Integer.MIN_VALUE;
        int j = Integer.MIN_VALUE;
        for (int i = 1; i < arr.length; i++) {
            key = arr[i];
            j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sort(new int[]{2, 5, 3, 9, 5, 1, 6, 4, 2})));
    }
}
