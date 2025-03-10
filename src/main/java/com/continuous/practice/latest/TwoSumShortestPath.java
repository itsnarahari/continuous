package com.continuous.practice.latest;

import java.util.Arrays;

public class TwoSumShortestPath {

    public static int[] twoSum(int[] numbers, int target) {
        int result[] = new int[2];
        int temp = 0;
        int counter = 0;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    int temp2 = i + j;
                    System.out.println(temp2);
                    if (temp2 < temp) {
                        System.out.println(i + " " + j);
                    } else {
                        temp = temp2;
                    }
                }
            }
        }
//        System.out.println(Arrays.toString(result));
        return null;
    }

    public static void main(String[] args) {
        int arr[] = {4, 6, 1, 9, 3, 89, 0, 2};
        System.out.println(Arrays.toString(twoSum(arr, 5)));
    }
}

