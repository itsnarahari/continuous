package com.continuous.practice;

public interface Func1 {
    int add(int a, int b);

    static void add2(int a, int b, int c) {
    }

}

class Driver {
    public static void main(String[] args) {
        Func1 func1 = (a, b) -> a + b;
        int add = func1.add(3, 4);
        System.out.println(add);
        String s1 = "dsf";
        String s2 = "dsf";

        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
    }
}

class Parent {
    public void m1() throws RuntimeException {
        System.out.println("parent m1");

    }
}

class Child extends Parent {
    public void m1() throws RuntimeException {
        System.out.println("child m1");
    }
}

class D {
    public static void main(String[] args) {
        Parent parent = new Child();
        parent.m1();
    }
}
