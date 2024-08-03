package com.test.practice.latest;

import java.util.Arrays;

public class ArrayRotationBothExample {

    public static void main(String[] args) {
        String s = "";
        System.out.println(s.toLowerCase().length());
        int v = 1;
        v++;
        System.out.println(v);
        int v2 = 1;
        ++v2;
        System.out.println(v2);
        int[] arr = {1, 2, 3, 4, 5,6,7};
        System.out.println(Arrays.toString(arr));
        rotate(arr,3);

//        reverseAnaArray(arr,0, arr.length-1);
//        System.out.println(Arrays.toString(reverseAnaArray(arr)));

        System.out.println(Arrays.toString(leftToRight(arr, 3)));
        System.out.println(Arrays.toString(rightToLeft(arr, 3)));
    }

    public static int[] leftToRight(int arr[], int k) {
        //Input: nums = [1,2,3,4,5,6,7], k = 3
        System.out.println("leftToRight");
        for (int i = 0; i < k; i++) {
            int temp = arr[0];
            for (int j = 0; j < arr.length - 1; j++) {
                arr[j] = arr[j + 1];
            }
            arr[arr.length - 1] = temp;
        }
        return arr;
    }

    public static int[] rightToLeft(int arr[], int k) {

        //Input: nums = [1,2,3,4,5,6,7], k = 3
        System.out.println("rightToLeft");
        for (int i = 0; i < k; i++) {
            int temp = arr[arr.length - 1];
            for (int j = arr.length - 1; j > 0; j--) {
                arr[j] = arr[j - 1];
            }
            arr[0] = temp;
        }
        return arr;
    }

    public static int[] reverseAnArray(int[] arr, int low, int high){
        while (low<arr.length-1 && high!=-1){
            int temp = arr[low];
            arr[low]=arr[high];
            arr[high]=temp;
            low++;
            high--;
        }
        System.out.println("Reversed");
        System.out.println(Arrays.toString(arr));
        return arr;
    }

    public static int[] rotate(int[] arr, int k){
        System.out.println(arr.length);
        reverseAnArray(arr,0, arr.length-1);
        reverseAnArray(arr,0,k-1);
        reverseAnArray(arr,k, arr.length-1);
        return arr;
    }
}
