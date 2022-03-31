package com.test.practice.latest;

import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collector;

public class NonZero {

    final static int NO_OF_CHARS = 256;

    @Override
    public String toString() {
        return "dsfs";
    }

    public static int[] zerosToEnd(int arr[]){
        int count = 0;  // Count of non-zero elements
        int n=arr.length;
        for (int i = 0; i < n; i++)
            if (arr[i] != 0)
                arr[count++] = arr[i]; // here count is
        System.out.println("countcount "+ count);
        System.out.println("----- "+ Arrays.toString(arr));
        while (count < n)
            arr[count++] = 0;
        return arr;
    }

    public static int[] zerosToFirst(int array[]){
        int count = array.length - 1;
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] != 0) {
                array[count--] = array[i];
            }
        }
        while (count >= 0) {
            array[count--] = 0;
        }
        return array;
    }

    public static void main(String[] args) throws FileNotFoundException {
        List<Integer> integers = List.of(3,0,3,0,8,9,0,7,9);
        System.out.println("Move zeros to first in array");
        System.out.println(Arrays.toString(zerosToFirst(new int[]{3,0,3,0,8,9,0,7,9,56,0,3,0})));
        System.out.println("Move zeros to end of array ");
        System.out.println(Arrays.toString(zerosToEnd(new int[]{3,0,3,0,8,9,0,7,9,56,0,3,0})));
    }
}
