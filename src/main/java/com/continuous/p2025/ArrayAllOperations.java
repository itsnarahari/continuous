package com.continuous.p2025;

import java.util.Arrays;

public class ArrayAllOperations {

    int[] arr = {2, 56, 0, 2, 6, 0, 1, 0};

    // o/p: 2,56,2,6,1,0,0,0
    // Time Complexity O(n): The array is traversed only once
    // Space Complexity: O(1): No extra space is used, making it memory efficient.
    public static int[] moveZerosToEnd(int[] arr) {

        int nonZeroIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                arr[nonZeroIndex++] = arr[i];
            }
        }
        while (nonZeroIndex < arr.length) {
            arr[nonZeroIndex++] = 0;
        }
        return arr;
    }

    public static int[] moveZerosToStart(int[] arr) {

        int nonZeroIndex = arr.length - 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] != 0) {
                arr[nonZeroIndex--] = arr[i];
            }
        }

        while (nonZeroIndex >= 0) {
            arr[nonZeroIndex--] = 0;
        }
        return arr;
    }

    public static int[] rotateArrayToRightByGivenK(int[] arr, int k) {

        for (int i = 0; i < k; i++) {


        }
        return arr;
    }

        public static void main(String[] args) {
        int[] arr = {2, 56, 0, 2, 6, 0, 1, 0};
        System.out.println("Input Array");
        System.out.println(Arrays.toString(arr));
        int[] moveZerosToEndResult = moveZerosToEnd(arr);

        System.out.println("Move zero's to end");
        System.out.println(Arrays.toString(moveZerosToEndResult));

        int[] moveZerosToStart = moveZerosToStart(arr);
        System.out.println("Move zero's to start");
        System.out.println(Arrays.toString(moveZerosToStart));
    }
}
