package com.test.practice;

public class FindMinimumIntegerFromSortedArray {

    public FindMinimumIntegerFromSortedArray() {

    }

    private FindMinimumIntegerFromSortedArray(int a) {
    }

    public static void main(String[] args) {
        System.out.println(findMinimumIntegerFromSortedArray(new int[]{4,5,1,2,3}));
        System.out.println(maxNeighbuoringSum(new int[]{4,2,5,8,7,3,7}));

    }
    public static int findMinimumIntegerFromSortedArray(int[] nums){
        int low=0;
        int high = nums.length-1;
        while (low<high){
            int mid = low+(high-low)/2;
            if(nums[mid]>nums[high]){
                low = mid+1;
            }else{
                high=mid;
            }
        }
        return nums[high];
    }

    public static int maxNeighbuoringSum(int[] arr){
        //        System.out.println(maxNeighbuoringSum(new int[]{4,2,5,8,7,3,7}));
        int size = arr.length-1;
//        int i=0, j=1;
//        int evenCounter=0;
//        while (j<size){
//            if(arr[i]+arr[j]%2==0){
//                evenCounter++;
//                i=i+2;
//                j=j+2;
//            }
//        }
//        return evenCounter;

//
//        for (int i = 0; i < size; i++) {
//            for (int j = 1; j < size; j++) {
//
//            }
//        }
        return 0;
    }
}
