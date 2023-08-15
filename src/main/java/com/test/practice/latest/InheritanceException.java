package com.test.practice.latest;

import java.util.HashMap;
import java.util.Map;

class Parent {

    public static void m2() throws Exception {
        System.out.println("parent m2");
    }

    private static void m3() {
        System.out.println("parent m2");
    }

    static final void m4() {
        System.out.println("parent m2");
    }

    public void m1() throws RuntimeException {
        System.out.println("parent m1");
    }
}

class Child extends Parent {
    @Override
    public void m1() throws NullPointerException {
        System.out.println("sds ");
    }
}

public class InheritanceException {

    public static void main(String[] args) {

        Map<Integer, String> map = new HashMap<>();
        map.put(12, "abcd");
        String f = map.put(12, "f");
        System.out.println(f);
        Throwable throwable = new RuntimeException();

        Integer i = new Integer(1);
        int i2 = 1;
        System.out.println(i == i2);
        System.out.println(i.equals(i2));

        String s1 = new String("str");
        String s2 = "str";
        System.out.println(s2.hashCode());
        System.out.println(s1.intern().hashCode());
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
//        Parent parent=new Child();
//        parent.m1();
    }
}
