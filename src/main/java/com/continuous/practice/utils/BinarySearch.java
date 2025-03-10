package com.continuous.practice.utils;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class BinarySearch {

    public static void main(String[] args) {

        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        copyOnWriteArrayList.add("sdas");

        Map map = new ConcurrentHashMap();

        int arr[] = {45, 6, 3, 4, 7, 8, 4, 5, 36, 56, 12, 83, 19, 43, 0};

        Arrays.sort(arr);
        int item = 19;

        int low = 0;
        int high = arr.length - 1;

        boolean flag = false;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == item) {
                flag = true;
                break;
            } else if (arr[mid] < item) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        if (flag) {
            System.out.println("Found ");
        } else {
            System.out.println("Not found ");
        }

    }
}
