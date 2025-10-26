package com.continuous.p2025;

import java.util.Arrays;

public class LeetCode {
    public static int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
//        int[] ints = twoSum(new int[]{2, 11, 7, 15}, 9);
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[] { left + 1, right + 1 }; // 1-indexed
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[] {}; // should not reach here if exactly one solution exists
    }
    public static void main(String[] args) {
        int[] ints = twoSum(new int[]{2, 11, 7, 15}, 9);
        System.out.println(Arrays.toString(ints));
    }
}
