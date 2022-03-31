package com.test.practice.utils;

public class FactorialNumber {

    public static int fact(int n){
        if (n == 0)
            return 1;
        return n*fact(n-1);
    }
    public static void main(String[] args) {
        System.out.println(fact(20));

        System.out.println(10/10);
        System.out.println(10%3);
    }
}
