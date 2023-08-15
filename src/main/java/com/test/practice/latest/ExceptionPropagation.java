package com.test.practice.latest;

public class ExceptionPropagation {

    public static void main(String[] args) {
        ExceptionPropagation exceptionPropagation = new ExceptionPropagation();
        exceptionPropagation.m2();
    }

    public void m1() {
        System.out.println("m1");
    }

    public void m2() throws NullPointerException {
        m1();
    }
}
