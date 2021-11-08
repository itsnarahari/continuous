package com.test.practice.test2;

class A {

    public void display(){
        System.out.println("parent");
    }

}

class B extends A{
    public void display() {
        System.out.println("Child");
    }
}

class Main2{
    public static void main(String[] args) {
        A a = new B();
        a.display();
    }
}