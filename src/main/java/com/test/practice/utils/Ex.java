package com.test.practice.utils;

public class Ex {

    public static void main(String[] args) {

        String s1="Hai"; String s2="Hai";

        String s3 = new String("Hai");

        System.out.println(s1==s3);

        System.out.println(s3 instanceof String);
        System.out.println(s1.equals(s2));
    }
}
