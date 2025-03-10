package com.continuous.practice.utils;

public class PalindromeNumber {

    public static boolean isNumberPalindrome(int n) {
        int rev = 0;
        boolean flag = false;
        int original = n;
        while (n != 0) {
            int rem = n % 10;
            rev = rev * 10 + rem;
            n /= 10;
        }
        if (rev == original) {
            flag = true;
        }
        return flag;
    }

    public static void main(String[] args) {
        System.out.println(isNumberPalindrome(252));
    }
}
