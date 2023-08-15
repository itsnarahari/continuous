package com.test.practice.oops;

import java.io.FileNotFoundException;

class Parent {

    public void m1() {
        System.out.println("m1");
    }

    public double m2() throws ClassCastException {
        System.out.println("m2");
        return 0;
    }

    protected double pro() {
        System.out.println("m2");
        return 0;
    }

    public static void m3() {
        System.out.println("m3");
    }

    private static void m4() {
        System.out.println("m4");
    }

    final static void m5() {
        System.out.println("m5");
    }

}

class Child extends Parent {
    @Override
    public double pro() {
        System.out.println("m2");
        return 0;
    }

    @Override
    public void m1() {
        System.out.println("From Child m1");
    }

    @Override
    public double m2() throws StackOverflowError {
        System.out.println("From Child m2");
        return 89d;
    }

    public static void m3() {
        System.out.println("m3");
    }
}

public class Inheritance {
    public static void main(String[] args) {
        Parent parent = new Child();
        parent.pro();
    }
}
