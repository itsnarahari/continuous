package com.continuous.p2025;


public class Parent {

    private int privateMethod(int i){
        return i;
    }

    private void staticMethod(){
    }

    void m1() throws ArrayIndexOutOfBoundsException{
        System.out.println("Parent m1");
    }

    static void display() {
        System.out.println("Static method in Parent class");
    }
}

class Child extends Parent{

    void m1() {
        System.out.println("Child m1");
    }
}
class Main{

    final int i=0;
    static int j;

    public static void main(String[] args) {
        Parent p= new Child();
        p.m1();
        System.out.println(j);
    }
}
