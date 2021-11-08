package com.test.practice.test2;

public class SecondLargestNumber {
    public static void secondLargest(){
        int[] arr={7,5,6,3,4,2};
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int small = Integer.MIN_VALUE;
        for(int i:arr){
            if(i>first){
                second=first;
                small=i;
                first=i;
            }
            else if(i<small){
                small=i;
            }
            else if(i>second){
                second=i;
            }
        }
        System.out.println("first "+first);
        System.out.println("second "+second);
        System.out.println("small "+small);
    }
    public static void main(String[] args) {
        secondLargest();
    }
}
