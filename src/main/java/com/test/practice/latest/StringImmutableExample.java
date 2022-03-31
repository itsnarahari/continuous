package com.test.practice.latest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringImmutableExample {

    final public int m1(){
        return 0;
    }

    public static void main(String[] args) {

        String s1 = "Hari";
        String obj = new String("Hari");
        String obj2=new String("Hari");
        System.out.println(obj==obj2);
        System.out.println(obj==obj);
        System.out.println(obj.equals(obj2));

        System.out.println();

        System.out.println(s1.hashCode());
        System.out.println(obj.hashCode());

        System.out.println(s1 == obj.intern());
        System.out.println(s1.equals(obj));

        List<String> list = new ArrayList<>(
                Arrays.asList("Geeks",
                        null,
                        "forGeeks",
                        null,
                        "A computer portal"));
        List<String> collect = list.stream().filter(s -> s != null).collect(Collectors.toList());
        System.out.println(collect);

        List<Integer> list1 = new ArrayList<>(
                Arrays.asList(3,
                        null,
                        7,
                        null,
                        9));
        List<Integer> collect1 = list1.stream().filter(i -> i != null).collect(Collectors.toList());
        System.out.println(collect1);
    }
}
