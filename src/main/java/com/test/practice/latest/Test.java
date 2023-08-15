package com.test.practice.latest;

public class Test {
    public static int findClosest(int arr[], int target) {
        int n = arr.length;

        int i = 0, j = n, mid = 0;
        while (i < j) {
            mid = (i + j) / 2;

            if (arr[mid] == target)
                return mid;
            if (target < arr[mid]) {
                if (mid > 0 && target > arr[mid - 1])
                    return getClosest(mid - 1, mid, target, arr);
                j = mid;
            } else {
                if (mid < n - 1 && target < arr[mid + 1])
                    return getClosest(mid, mid + 1, target, arr);
                i = mid + 1;
            }
        }

        return mid;
    }

    public static int getClosest(int val1, int val2, int target, int[] arr) {
        if (target - arr[val1] >= arr[val2] - target)
            return val2;
        else
            return val1;
    }

    // Driver code
    public static void main(String[] args) {
        int arr[] = {10, 20, 40, 50, 100};
        int target[] = {5, 25, 50, 120};
        for (Integer i : target) {

            if (i <= arr[0])
                System.out.println(arr.length + 1);
            else if (i >= arr[arr.length - 1])
                System.out.println(1);
            else
                System.out.println(arr.length - findClosest(arr, i));
        }
    }
}
