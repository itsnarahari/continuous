package com.test.practice.test2;

import java.util.Arrays;
import java.util.OptionalDouble;

public class ArraySquareOfOddNumbers {

    public static void squareOfOddInteger(int[] list){
        OptionalDouble sum = Arrays.stream(list).filter(n->n%2!=0).map(nMap->nMap*nMap).average();
        System.out.println(sum);
    }
    public static void main(String[] args) {
        int[] list = {2,7,9,3,4};
        squareOfOddInteger(list);
    }
}
