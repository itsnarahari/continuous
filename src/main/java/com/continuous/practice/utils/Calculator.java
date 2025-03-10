package com.continuous.practice.utils;

public class Calculator {

    public int add(int a, int b) {
        return MathUtil.addInteger(a, b);
    }
}

abstract class MathUtil {

    public static final int addInteger(int a, int b) {
        return a + b;
    }

    private MathUtil() {
    }
}