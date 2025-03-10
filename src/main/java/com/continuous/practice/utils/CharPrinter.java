package com.continuous.practice.utils;

public class CharPrinter {

    //input 3a2a5bxy
    public static String charPrinter(String str) {

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {

//            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
//                int value = Integer.parseInt(String.valueOf(str.charAt(i)));
//                for (int j = 0; j < value; j++) {
//                    stringBuilder.append(str.charAt(i + 1));
//                }
//                i++;
//            } else {
//                stringBuilder.append(str.charAt(i));
//            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(charPrinter("3a2a13bxy"));
    }
}
