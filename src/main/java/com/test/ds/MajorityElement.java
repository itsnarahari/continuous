package com.test.ds;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MajorityElement {

    public static int majorityElement(List<Integer> A){
        if(A.size()==1){
            return A.get(0);
        }
        Optional<Map.Entry<Integer, Long>> collect = A.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream().max(Comparator.comparing(Map.Entry::getValue));
        int frequencyKey = collect.get().getKey();

        int frequency = Integer.valueOf(String.valueOf(collect.get().getValue()));
        int halfOfTheList = (int) Math.floor(A.size()/2);
        if(frequency>halfOfTheList){
            return frequencyKey;
        }else{
            return -1;
        }
    }

    public static void main(String[] args) {
        System.out.println(majorityElement(Arrays.asList(1,1,2)));
    }
}
