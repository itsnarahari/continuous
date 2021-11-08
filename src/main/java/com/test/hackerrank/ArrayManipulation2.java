package com.test.hackerrank;

import java.util.*;

public class ArrayManipulation2 {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>(Arrays.asList(1,5,3));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(4,8,7));
        List<Integer> list3 = new ArrayList<>(Arrays.asList(6,9,1));

        List<List<Integer>> finalArray = new ArrayList<>();
        finalArray.add(list1);
        finalArray.add(list2);
        finalArray.add(list3);
        System.out.println(arrayManipulation(10,finalArray));
    }

    public static long arrayManipulation(int n, List<List<Integer>> queries) {
        long arr[]=new long[n+2];
        for (int i = 0; i < queries.size(); i++) {
            int k=0;
            int a=queries.get(i).get(0);
            int b=queries.get(i).get(1);
            if(queries.get(i).size()==3){
                k=queries.get(i).get(2);
            }
            System.out.println(" a = "+a+" b= "+b+" k= "+k);

//            arr[a]=arr[a]+k;
//            arr[b+1]=arr[b+1]-k;
        }
        System.out.println(Arrays.toString(arr));
        long max=0;
        for (int i = 0; i <= n; i++) {
            arr[i]=arr[i]+arr[i-1];
            max=Math.max(arr[i],max);
        }
        return max;
    }
}
