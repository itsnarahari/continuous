package com.test.practice.latest;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortListByCharacter {

    public static void main(String[] args) {

        List<String> list = List.of("narahari","bichani","papaiah","naveen","babu");

        list.stream().map(s->{
            s.getBytes();
            return s.trim();
        });
        List<String> collect = list.stream().sorted(Comparator.comparingInt(s -> s.charAt(2)))
                .collect(Collectors.toList());
        System.out.println(collect);
    }
}
