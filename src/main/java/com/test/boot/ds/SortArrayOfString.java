package com.test.boot.ds;

import java.util.Arrays;

public class SortArrayOfString {

    public static void main(String[] args) {
        String[] countries = {"Zimbabwe", "South-Africa", "India", "America", "Yugoslavia", " Australia", "Denmark", "France", "Netherlands", "Italy", "Germany"};
        Arrays.stream(sort(countries)).forEach(s -> System.out.println(s));
    }

    static String[] sort(String[] stringArray){
        for (int i = 0; i < stringArray.length - 1; i++) {
            for (int j = i+1; j < stringArray.length; j++) {
                if(stringArray[i].compareTo(stringArray[j])>0){
                    String temp = stringArray[i];
                    stringArray[i]=stringArray[j];
                    stringArray[j]=temp;
                }
            }
        }
    return stringArray;
    }
}
