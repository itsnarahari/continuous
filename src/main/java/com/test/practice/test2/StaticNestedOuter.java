package com.test.practice.test2;

public class StaticNestedOuter {


    public static void outerMethod(){
        System.out.println("Outer Method");
    }
    static class StaticNestedInnerClass{
        public static void main(String[] args) {
            outerMethod();
        }
    }
}
