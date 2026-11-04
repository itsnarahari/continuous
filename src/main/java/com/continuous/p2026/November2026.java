package com.continuous.p2026;

import com.continuous.practice.utils.In;

import java.util.*;

public class November2026 {
    public static void main(String[] args) {
        int number  = 487;
        int rev = 0;
        while (number!=0){
            int rem = number%10;
            System.out.print(rem);
            rev = rev * 10 + rem;
            number/=10;
        }
        System.out.println("Rev "+rev);

        boolean palindrome = isPalindrome(141);
        System.out.println(palindrome);
        boolean armstrong = isArmstrong(153);
        System.out.println(armstrong);
        List<Integer> numbers = Arrays.asList(10, 197, 400, 147, 30, 50, 231, 40, 20, 30, 300);
        int arr[] = {10, 20, 400, 147, 30, 50, 231,3, 40, 20, 10, 400, 401};
        int[] sortedArray = {1,1,2,2,3 };
        int[] unSortedArray = {1,-1,2,2,3, 1, 2};
//        int max = max(arr);
//        System.out.println("max "+max);
//        int min = min(arr);
//        System.out.println("MIN "+ min);
//        int i = secondLargest(arr);
//        System.out.println(i);
//        int[] ints = reverseAnArray(arr);
//        System.out.println("rev "+Arrays.toString(ints));
//        System.out.println("Is Array Sorted: "+ isArrayIsSorted(sortedArray));
//        System.out.println("Is Array Sorted: "+ isArrayIsSorted(unSortedArray));
//        removeDuplicateFromSortedArray(sortedArray);
        int[] arr44 = leftRotateTheArrayByOnePlace(arr, arr.length);
        System.out.println(Arrays.toString(arr44));
        int[] arr45 = leftRotateTheArrayByDPlaces(arr, 2);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr45));
        int[] arr1 = {1,2,2,3,4,5};
        int[] arr2 = {2, 3, 4, 4, 5, 6};
        List<Integer> theUnionOfTwoSortedArray = findTheUnionOfTwoSortedArray(arr1, arr1.length, arr2, arr2.length);
        System.out.println(theUnionOfTwoSortedArray);
        Set<Integer> union = findUnion(arr1, arr2);
        System.out.println(union);
        int[] arr3 = {0, 1, 0, 3, 12};
        System.out.println(Arrays.toString(moveZerosToEnd(arr3, arr3.length)));
        System.out.println(isAnagram("silent", "listen"));

    }

    public static boolean isAnagram(String s1, String s2) {

        if (s1.length() != s2.length()) {
            return false;
        }

        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        return Arrays.equals(arr1, arr2);
    }

//    Metric	Complexity
//    Time	O(n)
//    Space	O(1)
//    Technique	Two pointers
    //         int[] arr3 = {0, 1, 0, 3, 12};
    public static int[] moveZerosToEnd(int[] arr, int n){
        int j=-1;
        for (int i = 0; i < n; i++) {
            if(arr[i]==0){
                j=i;
                break;
            }
        }
        if(j==-1){
            return arr;
        }
        for (int i = j+1; i < n; i++) {
            if(arr[i]!=0){
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                j++;
            }
        }
        return arr;
    }

    public static Set<Integer> findUnion(int[] arr1, int[] arr2) {
        Set<Integer> set = new TreeSet<>();

        for (int i = 0; i < arr1.length; i++) {
            set.add(arr1[i]);
        }
        for (int i = 0; i < arr2.length; i++) {
            set.add(arr2[i]);
        }
        return set;
    }
    // Find the union of two sorted array
    public static List<Integer> findTheUnionOfTwoSortedArray(
            int[] arr1, int n1, int[] arr2, int n2) {

        List<Integer> union = new ArrayList<>();

        int i = 0, j = 0;

        while (i < n1 && j < n2) {
            int value;
            if (arr1[i] < arr2[j]) {
                value = arr1[i++];
            }
            else if (arr2[j] < arr1[i]) {
                value = arr2[j++];
            }
            else {
                value = arr1[i];
                i++;
                j++;
            }
            if (union.isEmpty() ||
                    union.get(union.size() - 1) != value) {
                union.add(value);
            }
        }
        while (i < n1) {
            if (union.isEmpty() ||
                    union.get(union.size() - 1) != arr1[i]) {
                union.add(arr1[i]);
            }
            i++;
        }
        while (j < n2) {
            if (union.isEmpty() ||
                    union.get(union.size() - 1) != arr2[j]) {
                union.add(arr2[j]);
            }
            j++;
        }

        return union;
    }


     //Left rotate the array by d places
    public static int[] leftRotateTheArrayByDPlaces(int[] arr, int d){
        for (int i = 0; i < d; i++) {
            int temp = arr[i];
            for (int j = 1; j < arr.length; j++) {
                arr[j-1]=arr[j];
            }
            arr[arr.length-1] = temp;
        }
        return arr;
    }

    public static int[] leftRotateTheArrayByOnePlace(int[] arr, int n){
        int temp = arr[0];

        for (int i = 1; i < n; i++) {
            arr[i-1]=arr[i];
        }
        arr[n-1] = temp;
        return arr;
    }

    public static boolean removeDuplicateFromSortedArray(int[] arr){
        int i=0;
        for (int j = 1; j < arr.length; j++) {
            if (arr[i] != arr[j]) {
                i++;
                arr[i] = arr[j];
            }
        }

        i = i+1;
        System.out.println(i);
        for (int j = 0; j < i; j++) {
            System.out.print(arr[j]+" ");
        }
        return false;
    }

    public static boolean isArrayIsSorted(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            if(arr[i+1]>=arr[i]){

            }else{
                return false;
            }

        }
        return true;
    }

    public static boolean isPalindrome(int number){
        int rev = 0;
        int temp = number;
        while (number!=0){
            int rem = number%10;
            rev = rev * 10 + rem;
            number/=10;
        }
        return rev==temp;
    }

    public static boolean isArmstrong(int original){
        int counter=0;
        int number = original;
        while (number!=0){
            number/=10;
            counter++;
        }
        System.out.println(counter);
        int digits = String.valueOf(number).length();
        System.out.println("digits "+digits);


        int result = 0;
        number  =original;
        while (number!=0){
            int rem = number%10;
            int temp=1;
            for (int i = 1; i <= counter; i++) {
                temp = temp*rem;
            }
            result = result+temp;
            number/=10;
        }
        return original==result;
    }

    //Find maximum and minimum
    public static int max(int[] arr){

        if(arr.length<=0){
            return -1;
        }
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(arr[i]>max){
                max = arr[i];
            }
        }
        int asInt = Arrays.stream(arr).max().getAsInt();
        return max;
    }

    //Find maximum and minimum
    public static int min(int[] arr){

        if(arr.length<=0){
            return -1;
        }
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(arr[i]<min){
                min = arr[i];
            }
        }
        Arrays.stream(arr).min().getAsInt();
        return min;
    }

    //Second largest element
    public static int secondLargest(int[] arr){

        if (arr == null || arr.length < 2) {
            return -1;
        }
        int first = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int i = 1; i < arr.length; i++) {
            if(arr[i]>first){
                secondLargest = first;
                first = arr[i];
            }
            else if(arr[i]<first && arr[i]>secondLargest){
                secondLargest = arr[i];
            }

        }
        return secondLargest == Integer.MIN_VALUE ? -1 : secondLargest;
    }

    // Reverse an array
    public static int[] reverseAnArray(int[] arr) {

        if (arr == null) {
            return new int[0];
        }
        int[] rev = new int[arr.length];
        int pos = 0;

        for (int i = arr.length - 1; i >= 0; i--) {
            rev[pos] = arr[i];
            pos++;
        }

        return rev;
    }

}
