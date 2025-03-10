package com.continuous.practice.utils;

public class StringPalindrome {

    public static boolean isStringPalindrome(String str) {
        String rev = "";
        boolean flag = false;
        for (int i = str.length() - 1; i >= 0; i--) {
            rev = rev + str.charAt(i);
        }
        System.out.println(rev);

        if (str.equalsIgnoreCase(rev)) {
            flag = true;
        }
        return flag;
    }

    public static void main(String[] args) {
        System.out.println(isStringPalindrome("abab"));
    }
}
