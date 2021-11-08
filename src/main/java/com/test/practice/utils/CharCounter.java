package com.test.practice.utils;


public class CharCounter {

    public static String charCounter(String str) {

        StringBuilder stringBuilder = new StringBuilder();
        char prevChar = 0;
        char charArray[] = str.toCharArray();
        int counter = 1;

        for (char i : charArray) {
            if (prevChar == i) {
                counter++;
            } else {
                if (prevChar != 0) {
                    stringBuilder.append(prevChar).append(counter);
                    counter = 1;
                }
                prevChar = i;
            }
        }
        return stringBuilder.toString();
    }

    public static String charCounter2(String str) {

        StringBuilder stringBuilder = new StringBuilder();
        char[] inputChars = str.toCharArray();
        char prevChar = ' ';
        int counter = 0;

        for (char c : inputChars) {
            if (c == prevChar) {
                counter++;
            } else {
                stringBuilder.append(prevChar).append(counter);
                counter = 1;
                prevChar = c;
            }
        }
        System.out.println(stringBuilder.toString());
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(charCounter2("aaabcc"));
    }
}
