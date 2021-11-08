package com.test.hackerrank;

import java.util.List;

public class TwoDArrayMax {

    public static int hourglassSum(List<List<Integer>> arr) {
        int maxHourGlass = Integer.MIN_VALUE;
        int rowLen = arr.size();
        int colLen = arr.get(0).size();
        for (int r = 0; r < rowLen-2; r++) {
            for (int c = 0; c < colLen-2; c++) {
                int currentHourGlassSum = arr.get(r).get(c) + arr.get(r).get(c + 1) + arr.get(r).get(c + 2)
                        + arr.get(r + 1).get(c + 1)
                        + arr.get(r + 2).get(c) + arr.get(r + 2).get(c + 1) + arr.get(r + 2).get(c + 2);

                maxHourGlass = Math.max(maxHourGlass, currentHourGlassSum);
            }
        }
        return maxHourGlass;
    }

    public static void main(String[] args) {
//        System.out.println(hourglassSum());
    }

}
