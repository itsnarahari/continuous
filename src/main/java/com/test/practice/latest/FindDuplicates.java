package com.test.practice.latest;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FindDuplicates {

    public static void main(String[] args) {
        List list = Arrays.asList(6,3,9,1,0,4,4,7,2,8,3,5,9);

        Object collect = list.stream().filter(o -> Collections.frequency(list, o) > 1).collect(Collectors.toSet());
        System.out.println(collect);

    }
}
