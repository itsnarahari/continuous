package com.continuous.practice.latest;

import java.util.Arrays;

public class ArrayRotations {
    public static int[] leftToRight(int arr[], int k) {
        for (int i = 1; i <= k; i++) {
            int temp = arr[0];
            for (int j = 0; j < arr.length - 1; j++) {
                arr[j] = arr[j + 1];
            }
            arr[arr.length - 1] = temp;
        }
        return arr;
    }

    public static int[] rightToLeft(int arr[], int k) {
        for (int i = 1; i <= k; i++) {
            int last = arr[arr.length - 1];
            for (int j = arr.length - 1; j > 0; j--) {
                arr[j] = arr[j - 1];
            }
            arr[0] = last;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] inputs = {1, 2, 3, 4, 5, 6};
        int k = 2;
        System.out.println("leftToRight");
        System.out.println("Input");
        System.out.println(Arrays.toString(inputs));
        int[] ints = leftToRight(inputs, k);

        System.out.println("Output");
        System.out.println(Arrays.toString(ints));

    }
}
