package com.test.practice.latest;

public class AccessModifierExample {

    private int id;
    static String s;
    final String finalString;

    public AccessModifierExample(String finalString) {
        this.finalString = finalString;
    }

    public void m1() {
        this.id = 45;
        this.s = "dfdsfds";
        System.out.println(id);
        System.out.println(s);
        System.out.println(finalString);
    }

    public static void main(String[] args) {
        AccessModifierExample accessModifierExample = new AccessModifierExample("finalString");
        accessModifierExample.m1();
        System.out.println(accessModifierExample.id);

    }
}
