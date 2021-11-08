package com.test.practice.utils;

public class SumPair {

    public static String findPairOfSum(int arr[],int num){
        StringBuilder stringBuilder = new StringBuilder();
        if(arr.length>0){
            for(int i=0;i<arr.length-1;i++){
                for(int j=i+1;j<arr.length-1;j++){
                    int a = arr[i]+arr[j];
                    if(a==num){
                        stringBuilder.append(i).append(",").append(j).append("\n");
//                        return stringBuilder.toString();
                    }
                }
            }
            return stringBuilder.toString();
        }
        else {
            return "empty array";
        }
    }
    public static void main(String[] args) {
        System.out.printf(findPairOfSum(new int[]{2,9,4,5,1,6,9},10));
    }
}