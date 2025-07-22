package com.continuous.p2025;

public class Prep {

    public static void m1(Object obj){
        System.out.printf("obj");
    }

    public static void m1(String string){
        System.out.println("string");
    }

    public static void m2(Integer integer){
        System.out.println("integer");
    }

    public static void m2(Double doubl){
        System.out.println("doubl");
    }


    public static void main(String[] args) {
        m1(null);
        m2(null);
    }
}
