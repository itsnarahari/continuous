package com.continuous.practice.test2;

public class CountChars {

    public static String countChars(String str) {


        char c[] = str.toCharArray();
        char temp = 0;
        StringBuffer sb = new StringBuffer();
        int counter = 1;
        for (char eachChar : c) {
            if (temp == eachChar) {
                counter++;
            } else {
                if (counter > 1) {
                    sb.append(temp).append(counter).toString();
                    counter = 1;
                } else {
                    System.out.println("in else");
                    sb.append(temp).append(counter).toString();
                    counter = 1;
                }
                temp = eachChar;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(countChars("taaabbxbbgghh"));

    }
}
