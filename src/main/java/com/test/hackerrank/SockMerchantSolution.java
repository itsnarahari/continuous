package com.test.hackerrank;

import java.util.*;

public class SockMerchantSolution {

    public static void main(String[] args) {
        Integer ar[] = {10, 20, 20, 10, 10, 30, 50, 10, 20};
        System.out.println(sockMerchant(ar.length, Arrays.asList(ar)));
    }

    public static int sockMerchant(int n, List<Integer> ar){
        HashSet<Integer> set = new HashSet<Integer>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            int element = ar.get(i);
            if (set.contains(element)) {
                set.remove(element);
                count++;
            } else {
                set.add(element);
            }
        }
        return count;
    }
}
