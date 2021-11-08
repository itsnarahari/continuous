package com.test.practice.utils;

import java.util.Arrays;

public class BubbleSortTest {
    public static void main(String[] args) {
        int arr[] = {45,6,3,4,7,8,4,5,36,56,12,83,19,43,0};
        int temp=0;
        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-1-i;j++){
                if(arr[j]>arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
