package com.continuous.p2026;

public class MixOfProblems {

    public static void main(String[] args) {
        System.out.println(isPalindrome("racecar"));
        System.out.println(isPalindromeByTwoPointers("raceqar"));
        System.out.println(isPrime(4));
        primeNumbersUpToMax(20);
    }

    // Reverse and String and check is palindrome Or Not
    public  static boolean isPalindrome(String str){
        StringBuilder reversed = new StringBuilder();

        for (int i = str.length() - 1; i >= 0; i--) {
            reversed.append(str.charAt(i));
        }
        return str.contentEquals(reversed);
    }


    public  static boolean isPalindromeByTwoPointers(String str) {
        int left=0, right = str.length()-1;
        // str= "rwcecar"
        while(left<right){
            if(str.charAt(right)!=str.charAt(left)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static boolean isPrime(int number){
        for (int i = 2; i <=Math.sqrt(number); i++) {
            if(number%i==0){
                return false;
            }
        }
        return true;
    }

    public static void primeNumbersUpToMax(int max){
        for (int i = 0; i <= max; i++) {
            for (int j = 2; j < i/2; j++) {
                if(j%2!=0){
                    System.out.print(j+", ");
                    break;
                }
            }


        }
    }

}
