package com.test.praveen;

@FunctionalInterface
public interface FunctionalInterfaceExample {
    public void m1(int a, int b);

    static void m2() {
    }

    default void m3() {
    }
}

interface FunctionalInterface2 extends FunctionalInterfaceExample {

    int id = 0;

    public void m1(int a, int b);

    static void m2() {
        System.out.println(id);
    }

    default void m3() {
    }
}

class Example {

    public static void main(String[] args) {

        int id = FunctionalInterface2.id;
        FunctionalInterface2 functionalInterface2 = (a, b) -> {
            int c = a + b;
            System.out.println(c);
        };
        functionalInterface2.m1(4, 6);
    }

}
