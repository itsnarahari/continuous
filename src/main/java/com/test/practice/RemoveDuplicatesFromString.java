package com.test.practice;

import java.util.HashMap;
import java.util.Map;

public class RemoveDuplicatesFromString {

    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap();

        map.put(1,1);
        map.put(2,2);
        map.put(3,3);
        int sum = map.entrySet().stream().mapToInt(value -> value.getKey() + value.getValue()).sum();
        System.out.println(sum);

        System.out.println(removeDuplicatesCharsFromSTring("aabbcdeeeeaa"));
        System.out.println(getPeakIndexOfAnArray(new int[]{1,2,4,6,8,7,5,3,0}));
    }


    public static String removeDuplicatesCharsFromSTring(String str){
        char temp = 0;
        String result="";
        //AABBCDDEEEAA
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i)==temp){
                System.out.print(str.charAt(i));
                result+=str.charAt(i);
            }else{
                temp = str.charAt(i);
            }
        }
        return result;
    }
    
    public static int getPeakIndexOfAnArray(int arr[]){
        // 1,2,4,8,7,5,3,0
        int temp = -1;
        int i = 0 , j = 1 , result = -1;
        while (j < arr.length && i < j){
            if(arr[j] > arr[i]){
                i++;
                j++;
            }
            else{
                result = i;
                break;
            }
        }
        return result;
    }
}
