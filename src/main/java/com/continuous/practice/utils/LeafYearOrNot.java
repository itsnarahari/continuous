package com.continuous.practice.utils;

public class LeafYearOrNot {

    public static boolean leafOrNot(int year) {

        if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(leafOrNot(2021));
    }
}
