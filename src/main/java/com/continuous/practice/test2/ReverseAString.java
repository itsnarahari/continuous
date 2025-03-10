package com.continuous.practice.test2;

public class ReverseAString {

    public static String reverseString(String str) {
        System.out.println(new StringBuffer(str).reverse());
        if (!str.isEmpty()) {
            String rev = "";
            char c[] = str.toCharArray();
            if (c.length > 1) {
                for (int i = c.length - 1; i >= 0; i--) {
                    rev += c[i];
                }
                return rev;
            }
        } else {
            return "EMpty String";
        }
        return "";
    }

    public static void main(String[] args) {
        System.out.println(reverseString("Narahari"));

    }
}
