package com.test.practice.latest;

public class StaticAndFinalExample {
    static int i = 10;
    final int i3 = 0;

    int i2=0;
    public int a() {
        i = 3;
        return i;
    }

    public static void main(String[] args) {
        StaticAndFinalExample staticAndFinalExample = new StaticAndFinalExample();
        System.out.println(staticAndFinalExample.a());
    }
}
