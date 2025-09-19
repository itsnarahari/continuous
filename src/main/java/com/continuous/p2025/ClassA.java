package com.continuous.p2025;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ClassA {
    public void m1() throws Exception{
        System.out.println("ClassA m1");
    }
}
class ClassB extends ClassA{
    @Override
    public void m1() throws NullPointerException {
        System.out.println("ClassA m1");
    }
}

class Driver{
    public static void main(String[] args) {
        ClassB classB = new ClassB();
        classB.m1();

    }
}
