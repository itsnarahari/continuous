package com.continuous.p2025;

public class SepTest {

    static {
        System.out.println("Static");
    }
    {
        System.out.println("Anonymous");
    }
    public SepTest(){
        System.out.println("public");
    }
    private SepTest(Integer i){
        System.out.println("private");
    }
    public static void main(String[] args) {
        new SepTest();
        System.out.println("main");
    }
}
