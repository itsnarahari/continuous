package com.test.boot.ds;

import java.util.Arrays;

public class SelectionSort {

    static void sort(int arr[]){
        int n=arr.length;
        for (int i = 0; i < n - 1; i++) {
            int min=i;
            for (int j = i+1; j < n; j++) {
                if(arr[j]<arr[min]){
                    min=j;
                }
            }
            int temp=arr[min];
            arr[min]=arr[i];
            arr[i]=temp;
            System.out.println(Arrays.toString(arr));
        }
    }

    public static void main(String[] args) {
        int arr[]={3,5,1,9,5,9};
        sort(arr);
    }
}
