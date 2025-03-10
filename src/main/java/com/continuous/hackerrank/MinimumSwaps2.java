package com.continuous.hackerrank;

public class MinimumSwaps2 {
    static int minimumSwaps(int[] a) {
        int swap = 0;
        for (int i = 0; i < a.length; i++) {
            if (i + 1 != a[i]) {
                int t = i;
                while (a[t] != i + 1) {
                    t++;
                }
                int temp = a[t];
                a[t] = a[i];
                a[i] = temp;
                swap++;
            }
        }
        return swap;
    }

    public static void main(String[] args) {
        int arr[] = {7, 1, 3, 2, 4, 5, 6};

        System.out.println(minimumSwaps(arr));
    }
}
