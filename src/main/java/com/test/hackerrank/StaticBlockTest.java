package com.test.hackerrank;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class StaticBlockTest {

    static {
        System.out.println("Static");
    }

    {
        System.out.println("instance default");
    }

    public StaticBlockTest() {
        System.out.println("constructor");
    }

    public static void main(String[] args) {
        Set set = new HashSet();
        set.add(null);
        set.add(null);
        System.out.println(set.size());
        StaticBlockTest staticBlockTest = new StaticBlockTest();
        staticBlockTest = new StaticBlockTest();
        System.out.println("ssss");
        String str = null;
        Optional<Object> o = Optional.ofNullable(null);
        System.out.println(o.map(o1 -> o1).get());
    }
}
