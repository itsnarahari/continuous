package com.continuous.practice.latest;

public class Example {


    public static String checkIsNull(String value) {
        if (value.startsWith("null") && value.contains("null")) {
            return "NA";
        }
        return value;
    }

    public static void main(String[] args) {
        System.out.println(Integer.parseInt("0"));
        System.out.println(Float.parseFloat("null"));
        System.out.println(Double.parseDouble("null"));
    }
}
