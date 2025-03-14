package com.continuous.p2025;

import java.util.Arrays;

public class TwoSum {


    public static int[] twoSum(int[] numbers, int target) {

        for(int i=0;i<numbers.length;i++){
            for(int j=i+1; j<numbers.length;j++){
                int currentSum = numbers[i]+numbers[j];
                if(currentSum==target){
                    return new int[]{i+1,j+1};
                }
            }
        }
        return new int[]{};
    }

//    public static int[] twoSum(int[] numbers, int target) {
//        int left = 0, right = numbers.length - 1;
//
//        while (left < right) {
//            int sum = numbers[left] + numbers[right];
//
//            if (sum == target) {
//                return new int[] {left + 1, right + 1}; // 1-based index
//            } else if (sum < target) {
//                left++;
//            } else {
//                right--;
//            }
//        }
//
//        // If no solution is found (though it's guaranteed to exist)
//        return new int[] {};
//    }

    public static String fractionToDecimal(int numerator, int denominator) {

        String d = String.valueOf(numerator/denominator);
        String str = d;
        if(!str.contains(".")){
            return str;
        }else {
            String[] fraction = str.split("\\.");
            if(fraction[1].length()>1){
                return String.format("%s.(%s)", fraction[0], fraction[1]);
            }else{
                return str;
            }
        }

    }
    public static void main(String[] args) {

        int[] numbers = {7,24,1,8,15};
        System.out.println(Arrays.toString(twoSum(numbers, 9)));
        System.out.println(fractionToDecimal(1,2));

    }
}
