package com.continuous.practice.latest;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class KthElementsFromArray {

    public static int findKthLargestValueByStreamAPI(List list, int k){
        if(list.size()!=k){
            return -1;
        }
        return (int) list.stream().sorted().skip(k-1).findFirst().get();
    }
    public static int findKthLargest(List<Integer> ints, int k) {
        // base case
        if (ints == null || ints.size() < k) {
            System.exit(-1);
        }

        // create a min-heap using the `PriorityQueue` class and insert
        // the first `k` array elements into the heap
        PriorityQueue<Integer> pq = new PriorityQueue<>(ints.subList(0, k));

        // do for remaining array elements
        for (int i = k; i < ints.size(); i++) {
            // if the current element is more than the root of the heap
            if (ints.get(i) > pq.peek()) {
                // replace root with the current element
                pq.poll();
                pq.add(ints.get(i));
            }
        }

        // return the root of min-heap
        return pq.peek();
    }

    public static void main(String[] args) {
        List<Integer> ints = Arrays.asList(7, 4, 6, 3, 9, 1);
        int k = 7;
        System.out.println(findKthLargestValueByStreamAPI(ints, k));
//        // 1,3,4,6,7,9
//        Integer i = ints.stream().sorted().skip(k-1).findFirst().get();
//        System.out.println(i);

        System.out.println("k'th largest array element is " + findKthLargest(ints, k));
    }
}
