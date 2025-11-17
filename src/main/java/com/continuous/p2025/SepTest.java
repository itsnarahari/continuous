package com.continuous.p2025;

import java.util.ArrayList;
import java.util.List;

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
        new SepTest();
        System.out.println("main");
        List<Integer> integers = new ArrayList<Integer>();
        integers.add(5);
        integers.add(10);
        integers.add(20);
        for(Integer i: integers){

        }
        for (int i = 0; i < integers.size(); i++) {
            integers.remove(1);
        }
        System.out.println(integers);
    }
}

