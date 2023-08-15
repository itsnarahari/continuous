package com.test.practice.utils;

interface AI {
    default void display() {
        System.out.println("AI");
    }
}

interface BI {
    default void display() {
        System.out.println("BI");
    }
}

class MainClass implements AI, BI {

    @Override
    public void display() {
        AI.super.display();
        BI.super.display();
    }

    public static void main(String[] args) {
        MainClass mainClass = new MainClass();
        mainClass.display();
    }
}
