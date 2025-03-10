package com.continuous.p2025;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Parent {

    private int privateMethod(int i){
        return i;
    }

    private void staticMethod(){
    }

    void m1() throws ArrayIndexOutOfBoundsException{
        System.out.println("Parent m1");
    }
}

class Child extends Parent{

    void m1() {
        System.out.println("Child m1");
    }
}
class Main{
    public static void main(String[] args) {
        Parent p= new Child();
        p.m1();
    }
}
