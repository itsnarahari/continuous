package com.test.boot.ds;

public class InsertionSort {

    static int[] sort(int arr[]){
        int n = arr.length;
        for (int i=1; i<n; ++i)
        {
            int key = arr[i];
            int j = i-1;

            while (j>=0 && arr[j] > key)
            {
                arr[j+1] = arr[j];
                j = j-1;
            }
            arr[j+1] = key;
        }
        return arr;
    }
    public static void main(String[] args) {
        System.out.println(sort(new int[]{2, 6, 3, 9, 1, 6}));
    }
}
