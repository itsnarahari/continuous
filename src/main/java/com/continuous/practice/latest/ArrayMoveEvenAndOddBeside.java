package com.continuous.practice.latest;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ArrayMoveEvenAndOddBeside {

    public static int[] separateEvenOddNumbers(int arr[]) {
        int left = 0;
        int right = arr.length - 1;
        for (int i = 0; i < arr.length; i++) {
            while (arr[left] % 2 == 0) {
                left++;
            }
            while (arr[right] % 2 == 1) {
                right--;
            }
            if (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] inputs = {3, 6, 11, 8, 9, 4, 6, 7, 9, 2};
        Map<Boolean, List<Integer>> collect = Arrays.stream(inputs).mapToObj(value -> value).collect(Collectors.partitioningBy(o -> o % 2 == 0));
        System.out.println(collect.get(true) + " " + collect.get(false));
        int[] resp = separateEvenOddNumbers(inputs);
        System.out.println(Arrays.toString(resp));
    }
}
