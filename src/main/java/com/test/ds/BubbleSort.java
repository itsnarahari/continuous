package com.test.ds;

import java.util.Arrays;

public class BubbleSort {

    public static int[] sort(int arr[]){

        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if(arr[j]<arr[i]){
                    int temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sort(new int[]{2,5,3,9,5,1,6,4,2})));
    }
}
