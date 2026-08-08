package com.continuous.p2026;

import java.util.Arrays;

public class RotateArray {

    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5,6,7};
        int k=3;
        rightRotate(arr, k);
        arr=new int[]{1,2,3,4,5,6,7};
        leftRotate(arr, k);
    }

    public static void rightRotate(int[] arr, int k) {
        int n = arr.length;
        // Handle k > n
        k = k % n;
        System.out.println("Right Rotate");
        System.out.println("Original Array "+ Arrays.toString(arr));
        reverse(arr, 0, n - 1);
        System.out.println("After 1st One "+ Arrays.toString(arr));
        reverse(arr, 0, k - 1);
        System.out.println("After 2nd One "+ Arrays.toString(arr));
        reverse(arr, k, n - 1);
        System.out.println("After 3rd One "+ Arrays.toString(arr));
    }

    public static void leftRotate(int[] arr, int k) {
        int n = arr.length;

        k = k % n;
        System.out.println("Left Rotate");
        System.out.println("Original Array "+ Arrays.toString(arr));
        // Step 1: Reverse first k elements
        reverse(arr, 0, k - 1);
        System.out.println("After 1st One "+ Arrays.toString(arr));
        // Step 2: Reverse remaining elements
        reverse(arr, k, n - 1);
        System.out.println("After 2nd One "+ Arrays.toString(arr));
        // Step 3: Reverse entire array
        reverse(arr, 0, n - 1);
        System.out.println("After 3rd One "+ Arrays.toString(arr));

    }
    private static void reverse(int[] arr, int left, int right){
        while (left<right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}
