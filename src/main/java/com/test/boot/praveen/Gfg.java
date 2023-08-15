package com.test.boot.praveen;

// Java program to find the minimum
// number of swaps required to sort
// the given array

import java.io.*;
import java.util.*;

class Gfg {

    static int minimumSwaps(int[] arr) {
        int swap = 0;
        boolean visited[] = new boolean[arr.length];

        for (int i = 0; i < arr.length; i++) {
            int j = i, cycle = 0;

            while (!visited[j]) {
                visited[j] = true;
                j = arr[j] - 1;
                cycle++;
            }

            if (cycle != 0)
                swap += cycle - 1;
        }
        return swap;
    }

    // Driver code
    public static void main(String[] args) {
        int arr[] = {15, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};

        // Function to find minimum swaps
        System.out.println(minimumSwaps(arr));
    }
}