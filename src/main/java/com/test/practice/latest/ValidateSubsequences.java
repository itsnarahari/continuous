package com.test.practice.latest;

import java.util.Arrays;
import java.util.List;

public class ValidateSubsequences {

    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
        boolean b = array.containsAll(sequence);
        return b;
    }

    public static void main(String[] args) {
        System.out.println(isValidSubsequence(Arrays.asList(5,1,22,25,6,-1,8,10),Arrays.asList(1,6,-1,7)));
    }
}
