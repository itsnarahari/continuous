package com.test.practice.utils;

import java.util.HashSet;
import java.util.Set;

public class RemoveArrayDuplicates {

    public static Set<Integer> removeDuplicates(int arr[]){

//        Set<Integer> set = new HashSet(Arrays.stream(arr).collect(Collectors.toSet()));
//        Set<Integer> set = new HashSet(Arrays.asList(arr));
//        for(int i = 0; i < arr.length; i++){
//            set.add(arr[i]);
//        }
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = i+1; j < arr.length; j++) {
//                if(arr[i]==arr[j]){
//                    arr[j]=arr[j];
//                }
//            }
//        }
        return new HashSet<>();
    }
    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{45,7,89,4,6,3,4,6}));
        ;
    }
}
