package com.test.praveen;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        final List<Integer> list = new ArrayList<>();
        list.add(43);
        String s = null;
        try {
            Integer i = Integer.valueOf(s);
            System.out.println(i);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
