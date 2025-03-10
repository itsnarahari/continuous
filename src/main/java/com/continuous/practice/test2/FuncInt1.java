package com.continuous.practice.test2;

@FunctionalInterface
public interface FuncInt1 {
    public void m1();
}

interface FuncInt2 extends FuncInt1 {
}

class Imp implements FuncInt2 {

    @Override
    public void m1() {

    }
}
