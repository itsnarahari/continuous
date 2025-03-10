package com.continuous.practice.utils;

interface A {

}

interface InterfaceTest {
    static void m1() {
        System.out.println("m1");
    }

    class A {
        public static void m1() {
            System.out.println("m1");
        }
    }
}

class InterfaceDemo {
    public static void main(String[] args) {
        InterfaceTest.A.m1();
        InterfaceTest.m1();
    }
}
