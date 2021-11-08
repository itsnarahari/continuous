package com.test.practice.utils;

@FunctionalInterface // annotation for functional interface
interface FuncInterface {

    public int multiply(int a, int b);
    default void multiply2(int a, int b){
    }
    public static void multiply23(int a, int b){
    }
}

public class Java8 {

    public static void main(String args[]) {
        FuncInterface Total = (a, b) -> a * b;
        System.out.println("Result: "+Total.multiply(30, 60));
    }
}
