package com.continuous.practice.test2;

public class FIndAllSubstring {

    public static void findAllSubStrings(String str) {
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j < str.length(); j++) {
                System.out.println(str.substring(i, j));
            }
        }
    }

    public static void main(String[] args) {
        findAllSubStrings("abbc");
    }
}
