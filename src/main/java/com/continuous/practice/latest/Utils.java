package com.continuous.practice.latest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Utils {

    public static void m1(String str) {
        System.out.println(str);

    }

    public static void m1(Object str) {

    }

    {
        System.out.println("Instance block");
    }

    static {
        System.out.println("Static block");
    }

    public Utils() {
        System.out.println("constructor");
    }

    public static void main(String[] args) {
        Utils utils = new Utils();
        double floor = Math.floor(10 / 2);
        System.out.println(floor);
        Map map = new HashMap();
//        Utils utils2 = new Utils();

        int[] arr = {1, 2, 3, 4, 5, 6};
        System.out.println(Arrays.toString(arr));

        for (int j = 0; j < arr.length; j++) {
            int nextPos = arr[j];//1
            arr[j + 1] = nextPos;// 1
        }
        // 1 1

        System.out.println(Arrays.toString(arr));

    }
}
