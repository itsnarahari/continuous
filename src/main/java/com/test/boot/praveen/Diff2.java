package com.test.boot.praveen;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Diff2 {
    public static void main(String[] args) {
        int arr[] = {2, 3, 2};
        int n = 5;
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        System.out.println("resp " + min(list));
    }

    public static int min(List<Integer> ar) {
        int[] arr = ar.stream().mapToInt(i -> i).toArray();
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        int n = arr.length;
        System.out.println("len " + n);
        int sum = 0;
        sum += Math.abs(arr[0] - arr[1]);
        sum += Math.abs(arr[n - 1] - arr[n - 2]);
        for (int i = 1; i < n - 1; i++)
            sum +=
                    Math.min(Math.abs(arr[i] - arr[i - 1]),
                            Math.abs(arr[i] - arr[i + 1]));

        return sum;

    }
}