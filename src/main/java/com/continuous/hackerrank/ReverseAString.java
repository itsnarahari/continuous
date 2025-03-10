package com.continuous.hackerrank;

public class ReverseAString {

    public static String revString(String str) {
        String rev = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            rev += str.charAt(i);
        }
        return rev;
    }

    public static void main(String[] args) {
        System.out.println(revString("hello"));
    }
}
