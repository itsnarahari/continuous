package com.test.practice.latest;

import java.util.Optional;

public abstract class AbstractClassDemo {
    public void m1() {
        System.out.println("m1");
    }

    abstract void m2();
}

abstract class AbstractClassDemo2 extends AbstractClassDemo {
    public abstract void m2();
}

class MyClass extends AbstractClassDemo {
    public void m1() {
        System.out.println("MyClass.m1()");
    }

    public void m2() {
        System.out.println("m2");
    }
}

class Driver {
    public static void main(String[] args) {

        MyClass myClass = new MyClass();
        myClass.m1();
        AbstractClassDemo abstractClassDemo = new MyClass();
        abstractClassDemo.m1();
        abstractClassDemo.m2();
        Optional optional = null;
        System.out.println(optional.isPresent());
    }
}
