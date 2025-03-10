package com.continuous.hackerrank;

import java.util.*;

import static java.util.stream.Collectors.joining;

class Result {

    /*
     * Complete the 'arrayManipulation' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY queries
     */

    public static long arrayManipulation(int n, List<List<Integer>> queries) {
        int newArray[] = new int[n];
        for (int i = 0; i < queries.size(); i++) {
            int k = 0;
            int a = queries.get(i).get(0);
            int b = queries.get(i).get(1);
            if (queries.get(i).size() == 3) {
                k = queries.get(i).get(2);
            }
            System.out.println(" a = " + a + " b= " + b + " k= " + k);
            for (int j = a; j < b; j++) {
                newArray[j] = newArray[j] + k;
            }
            System.out.println(Arrays.toString(newArray));

        }
        OptionalInt max = Arrays.stream(newArray).max();
        return max.getAsInt();

    }

}

