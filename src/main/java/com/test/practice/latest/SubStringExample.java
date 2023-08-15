package com.test.practice.latest;

public class SubStringExample {

    public static void main(String[] args) {
        String originalString = "Narahari";
        String subString = originalString.substring(1, 4);
        System.out.println(subString);
        originalString = null;
        String substring2 = originalString.substring(1, 4);
        System.out.println(substring2);
    }
}
