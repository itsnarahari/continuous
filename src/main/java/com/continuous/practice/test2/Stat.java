package com.continuous.practice.test2;


public class Stat {

    public static void main(String[] args) {
        A a = new B();
        a.printMe();
    }

    static class A {
        static void printMe() {
            System.out.println("Hi from A");
        }
    }

    static class B extends A {
        static void printMe() {
            System.out.println("Hi from B");
        }
    }
}
