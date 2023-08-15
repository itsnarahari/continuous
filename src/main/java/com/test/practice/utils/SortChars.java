package com.test.practice.utils;

import java.util.Arrays;

public class SortChars {

    public static String[] mergeAndSortArray(String firstArray[], String secondArray[]) {

        String[] finalArray = {};
        if (firstArray.length > 0 && secondArray.length > 0) {

            // Get length.
            int finalLength = firstArray.length + secondArray.length;

            // Create a new Array.
            finalArray = new String[finalLength];
            int pos = 0;

            // Add the both arrays elements to new array.
            for (String element : firstArray) {
                finalArray[pos] = element;
                pos++;
            }
            for (String element : secondArray) {
                finalArray[pos] = element;
                pos++;
            }

            // Sort the finalArray.
            for (int i = 0; i < finalArray.length; i++) {
                for (int j = 0; j < finalArray.length; j++) {
                    if (finalArray[i].compareTo(finalArray[j]) < 0) {

                        //swapping arrays.
                        String temp = finalArray[i];
                        finalArray[i] = finalArray[j];
                        finalArray[j] = temp;
                    }
                }
            }

        } else {
            return finalArray;
        }
        return finalArray;
    }

    public static void main(String[] args) {
        String[] sortedArray = mergeAndSortArray(new String[]{"a", "c", "d", "f", "g"}, new String[]{"e", "b", "h"});
        System.out.println(Arrays.toString(sortedArray));
    }
}
