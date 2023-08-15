package com.test.practice;

interface TestInterface1 {
    void m1();
}

interface TestInterface2 extends TestInterface1 {
    void m1();
}

class DriverClass implements TestInterface2 {

    @Override
    public void m1() {

    }
}