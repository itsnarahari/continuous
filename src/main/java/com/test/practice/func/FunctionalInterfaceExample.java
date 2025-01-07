package com.test.practice.func;

import java.util.ArrayList;

interface FuncInterface {

    int add(int a, int b);

    default void d() {
        System.out.println("default method ");
    }

    static void staticM1() {
        System.out.println("Static Method");
    }

    class InnerClassOfInterface {
        public void innerMethod() {
            System.out.println("innerMethod ");
        }

        static void innerMethodStatic() {
            System.out.println("innerMethodStatic ");
        }

        private void innerMethodDefault() {
            System.out.println("innerMethodDefault ");
        }
    }
}

public class FunctionalInterfaceExample {

    public static void main(String[] args) {
        FuncInterface funcInterface = (a, b) -> a + b;
        int add = funcInterface.add(3, 7);
        funcInterface.d();
        System.out.println(add);
        FuncInterface.staticM1();
        var list = new ArrayList<String>();
        FuncInterface.InnerClassOfInterface innerClassOfInterface = new FuncInterface.InnerClassOfInterface();
        FuncInterface.InnerClassOfInterface.innerMethodStatic();
        innerClassOfInterface.innerMethod();

    }
}
