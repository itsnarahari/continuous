package com.continuous.practice.utils;

public class NonRepeatingChars {

    public static String firstNonRepeatingCharacters(String str) {

        char charArray[] = str.toCharArray();
        boolean flag = false;
        for (char c : charArray) {

            for (int i = 0; i < charArray.length; i++) {
                if (c == charArray[i]) {
                    flag = true;
                    System.out.println("duplicates found " + c);
                    break;
                }
            }
            break;
        }
        if (flag == true) {
            return "found";
        } else {
            return "Not found";
        }
    }

    public static void main(String[] args) {
        System.out.println(firstNonRepeatingCharacters("abahj"));
    }
}
