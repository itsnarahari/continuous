package com.continuous.p2025;

class AbstractExample{
    AbstractExample(){
        System.out.println("Abstract class constructor");
    }
}
class Child2 extends AbstractExample{
    Child2(){
        System.out.println("Child class constructor");
    }
}
public class OOPS {
    public static void main(String[] args) {
        Child2 obj = new Child2();
    }
}
