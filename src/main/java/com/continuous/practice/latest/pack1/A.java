package com.continuous.practice.latest.pack1;

public class A {
    protected void m1() {
        System.out.println("A m1()");
    }
}

class B extends A {


    public static void main(String[] args) {

        A a = new A();
        a.m1();
        B b = new B();
        b.m1();
        A a1 = new B();
        a1.m1();
    }

}
