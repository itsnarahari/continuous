package com.continuous.practice.test2;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class IntegerOccurences {

    public static void test() {
        Integer[] intArrayWrapperType3 = {10, 5, -44, -99, 47, 30, 30, 45, 25, 198, -35, 5, 10};
//        List<Integer> s = Arrays.asList(intArrayWrapperType3);
//        s.stream().filter(integer -> integer>10 & integer<50)
//                .forEach(integer -> );

        Map<Integer, Long> map = Arrays.stream(intArrayWrapperType3).filter(item -> item >= 10 && item <= 50).collect(Collectors.groupingBy(item -> item, Collectors.counting()));
        System.out.println(map);
    }


    public static void main(String[] args) {
        test();
        String[] s = "nnamme".split("");
        System.out.println(Arrays.toString(s));
        Map<String, Long> m = Arrays.stream(s).collect(Collectors.groupingBy(o -> o, Collectors.counting()));
        System.out.println(m);
    }
}
