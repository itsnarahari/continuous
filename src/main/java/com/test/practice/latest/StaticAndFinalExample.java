package com.test.practice.latest;

public class StaticAndFinalExample {
    static int i = 10;

    public int a() {
        i = 3;
        return i;
    }

    public static void main(String[] args) {
        StaticAndFinalExample staticAndFinalExample = new StaticAndFinalExample();
        System.out.println(staticAndFinalExample.a());
    }
}
