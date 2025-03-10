package com.continuous.hackerrank;

import java.util.Arrays;

public class MinimumSwaps {

    static int minimumSwaps(int[] arr) {
        System.out.println(Arrays.toString(arr));

        int count = 0;
        //sorting logic
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int tmp = 0;
                if (arr[i] > arr[j]) {
                    tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                    count++;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
        return count;

    }

    public static void main(String[] args) {
        System.out.println(minimumSwaps(new int[]{4, 3, 1, 2}));
    }
}
