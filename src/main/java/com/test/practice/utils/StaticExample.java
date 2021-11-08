package com.test.practice.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StaticExample {

    public static void hello(){
        System.out.println("Inside of hello() static method");
    }
    static {
        System.out.println("Static block");
    }
    public StaticExample(){
        System.out.println("constructor");
    }
    public static final void main(String[] args) {

        Optional<List> list = Optional.of(new ArrayList<List>());


        int v1,v2;
        StaticExample.hello();
    }
//    public static void main(Integer[] args) {
//        StaticExample.hello();
//    }
}
