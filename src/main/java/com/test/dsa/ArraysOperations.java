package com.test.dsa;

import java.util.Arrays;

public class ArraysOperations {

    //         int arr[] = {8, 1, 0, 2, 1, 0, 3};
    public static int[] moveZerosToEnd(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == 0) {
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int arr[] = {8, 1, 0, 2, 1, 0, 3};
        System.out.println("before Move");
        System.out.println(Arrays.toString(arr));
        System.out.println("Move zeros to end");
        System.out.println(Arrays.toString(moveZerosToEnd(arr)));
    }
}
