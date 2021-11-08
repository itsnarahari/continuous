package com.test.practice.test2;

public class RevAString {

    public static String reverseAString(String blogName){


        String reverse = "";
        for (int i = blogName.length() - 1; i >= 0; i--) {
            reverse = reverse + blogName.charAt(i);
        }
        System.out.println("Reverse of java2blog is: " + reverse);
        return reverse;
    }

    public static void main(String[] args) {
        System.out.println(reverseAString("Narahari"));
    }
}
