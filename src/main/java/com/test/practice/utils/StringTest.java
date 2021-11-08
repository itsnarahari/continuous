package com.test.practice.utils;

public class StringTest {

    public static void main(String[] args) {

        String str1 = "hai";
        String str2 = "Hai";
        String obj = new String();
        System.out.println(str1.equalsIgnoreCase(str2));
        System.out.println(str1==obj);

    }
}
