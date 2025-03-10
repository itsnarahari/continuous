package com.continuous.practice.latest;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamsAPICollectTwoLists {

    public static void main(String[] args) {
        List<Integer> stream = Arrays.asList(25, 50, 75, 100, 125, 150, 50);

        Map<Boolean, List<Integer>> m = stream.stream().collect(Collectors.partitioningBy(a -> Collections.frequency(stream, a) > 1));
        System.out.println("false = " + m.get(Boolean.FALSE));
        System.out.println("true = " + m.get(Boolean.TRUE));

    }
}
