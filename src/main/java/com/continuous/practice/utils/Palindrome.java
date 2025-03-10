package com.continuous.practice.utils;

public class Palindrome {

    public static String checkForPalindrome(int num) {

        int rev = 0, sum = 0;
        while (num > 0) {
            int temp = num % 10;
            sum = (sum * 10) + temp;
            num = num / 10;
        }

        if (num == sum) {
            return "paindrome";
        } else {
            return "Not a palindrome";
        }

    }

    public static void main(String[] args) {
        System.out.println(123 / 10);
        System.out.println(123 % 10);
        System.out.println(checkForPalindrome(121));
    }
}
