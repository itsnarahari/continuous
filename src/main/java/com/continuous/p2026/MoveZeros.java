package com.continuous.p2026;

import java.util.Arrays;

import static org.apache.commons.lang3.ArrayUtils.swap;

public class MoveZeros {

    public static void main(String[] args) {
        int arr[] = {2, 4, 0, 1, 0, 2, 8, 1, 0};
        System.out.println(Arrays.toString(moveZerosToEnd(arr, arr.length)));
        int arr2[] = {2, 4, 0, 1, 0, 2, 8, 1, 0};
        System.out.println(Arrays.toString(moveZerosToFront(arr2, arr2.length)));

    }

    public static int[] moveZerosToFront(int arr[], int n){
        int j=-1;
        n=n-1;
        for (int i = n; i>=0; i--) {
            if(arr[i]==0){
                j=i;
                break;
            }
        }
        if(j==-1){
            return arr;
        }
        for (int i = j-1; i>=0; i--) {
            if(arr[i]!=0){
                swap2(arr, j,i);
                j--;
            }
        }
        return arr;

    }

    public static int[] moveZerosToEnd(int[] arr, int n) {
        int j = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                j = i;
                break;
            }
        }
        if (j == -1) {
            return arr;
        }
        for (int i = j + 1; i < n; i++) {
            if (arr[i] != 0) {
                swap2(arr, i, j);
                j++;
            }
        }
        return arr;
    }

    public static void swap2(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
