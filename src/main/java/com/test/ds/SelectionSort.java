package com.test.ds;

import java.util.Arrays;

public class SelectionSort {

    public static int[] sort(int arr[]){
        int min=Integer.MIN_VALUE;
        for (int i = 0; i < arr.length-1; i++) {
            min=i;
            for (int j = i+1; j < arr.length; j++) {
                if(arr[j]<arr[min]){
                    min=j;
                }
            }
            int temp = arr[i];
            arr[i]=arr[min];
            arr[min]=temp;
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sort(new int[]{2,5,3,9,5,1,6,4,2})));
    }
}
