package com.continuous.p2026;

public class MixOfProblems {

    public static void main(String[] args) {
        System.out.println(isPalindrome("racecar"));
        System.out.println(isPalindromeByTwoPointers("raceqar"));
        System.out.println(isPrime(4));
        primeNumbersUpToMax(20);
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(123));
        System.out.println(sumOfDigits(12345));
        System.out.println(countOfDigits(123450));
        System.out.println(checkArmStrongNumber(153));
        System.out.println(checkArmStrongNumber(152));
        System.out.println(factorial(5));
//        System.out.println(factorial(0));
//        System.out.println(factorial(1));
//        System.out.println(factorial(-1));
        fibonacciSeries(20);
        test1(new Object());
        test1("hari");
        test1(324324);

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

    public static boolean isPalindrome(int number) {
        if (number < 0) {
            return false;
        }

        int original = number;
        int reversed = 0;

        while (number != 0) {
            int digit = number % 10;
            reversed = reversed * 10 + digit;
            number = number / 10;
        }

        return original == reversed;
    }

    public static boolean isPrime(int number){
        for (int i = 2; i <=Math.sqrt(number); i++) {
            if(number%i==0){
                return false;
            }
        }
        return true;
    }

    public static void primeNumbersUpToMax(int max) {

        for (int i = 2; i <= max; i++) {
            boolean isPrime = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
        }
        System.out.println();
    }

    public static int sumOfDigits(int number){
        //1234
        int sum=0;
        while (number!=0){
            int rem = number%10;
            sum +=rem;
            number = number/10;
        }
        return sum;
    }
    public static int countOfDigits(int number) {
        int counter=0;
        while (number!=0){
            number = number/10;
            counter++;
        }
        int length = String.valueOf(number).length();
        return counter;
    }

    public static boolean checkArmStrongNumber(int number){
        //number=153
        int sum=0;
        int original = number;
        int countOfDigits = countOfDigits(number);
        while (number!=0){
            int digit = number%10;
            sum = sum + power(digit, countOfDigits);
            number/=10;
        }
        return original==sum;

    }

    public static int power(int digit, int countOfDigits){
        int result=1;
        for (int i = 1; i <= countOfDigits; i++) {
            result = result * digit;
        }
        return result;
    }


    public static int factorial(int n){
        // n  = 5
        if(n<=1){
            throw new IllegalArgumentException("Number cannot be negative");
        }
        if (n <= 1) {
            return 1;
        }

        int result = 1;
        for (int i = n; i > 0; i--) {
            result *=i;
        }
        return result;

    }

    public static void fibonacciSeries(int n) {

        int first = 0;
        int second = 1;

        for (int i = 0; i < n; i++) {

            System.out.print(first + " ");

            int next = first + second;
            first = second;
            second = next;
        }
        System.out.println();
    }

    public static void test1(Object obj){
        System.out.println("Object");
    }

    public static void test1(String obj){
        System.out.println("String");
    }

    public static void test1(Integer obj){
        System.out.println("Integer");
    }


    }

