package com.test.boot.praveen;

import java.util.Arrays;

public class Diff {
    public static void main(String[] args) {
        int arr[]={1,3,3,2,4};
        int n= 5;
        System.out.println( min(arr,n));
    }

    public static int min(int arr[],int n){
        Arrays.sort(arr);
        int sum = 0;

        sum += Math.abs(arr[0] - arr[1]);
        sum += Math.abs(arr[n-1] - arr[n-2]);
        for (int i = 1; i < n - 1; i++)
            sum +=
                    Math.min(Math.abs(arr[i] - arr[i-1]),
                            Math.abs(arr[i] - arr[i+1]));

        return sum;

    }
}