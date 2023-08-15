package com.test.practice.utils;

public class TestCode {
    public static void main(String[] args) {
        m(new Object());
    }

    static void m(String str) {
        System.out.println("My");
    }

    static void m(Object str) {
        System.out.println("object");
    }
}
