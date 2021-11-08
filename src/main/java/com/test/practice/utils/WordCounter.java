package com.test.practice.utils;

public class WordCounter {


    public static String wordCounter(String str) {

        char charArray[] = str.toCharArray();

        char prevChar = 0;
        int counter = 1;
        StringBuilder stringBuilder = new StringBuilder();

        for (char i : charArray) {
            if (i == prevChar) {
                counter++;
            } else {
                if(counter>0){
                    stringBuilder.append(prevChar).append(counter);
                    counter = 0;
                }
                prevChar = i;
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(wordCounter("aabccc"));
    }
}
