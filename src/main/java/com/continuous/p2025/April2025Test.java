package com.continuous.p2025;

import jakarta.servlet.http.PushBuilder;

import java.util.HashMap;
import java.util.Map;

public class April2025Test {

    public static void main(String... args) {
//        1. Java program to Find Odd or Even number
        findOddOrEvenNumber(11);
        findPrimeOrNotNumber(0);
        findFibonacciSeries(10);
        reverseANumber(10);
        isArmStrongOrNot(9474);
        reverseAString("abc");
        findDuplicatesCharsInAString("abccd1eeee222fghh....%%%%");
    }

    //    1. Java program to Find Odd or Even number
    public static void findOddOrEvenNumber(int number) {
        if (number % 2 == 0) {
            System.out.println("This %d is Even number".formatted(number));
        } else {
            System.out.println("This %d is Odd number".formatted(number));
        }
    }

    //    2. Java program to find Prime number
    public static void findPrimeOrNotNumber(int number) {

        double n = Math.sqrt(number);
        System.out.println(n);
        System.out.println(number / 2);
        System.out.println(number % 2);
        boolean isPrime = isPrime(number);

        if (isPrime) {
            System.out.println("This %d is prime number".formatted(number));
        } else {
            System.out.println("This %d is not a prime number".formatted(number));
        }
    }

    public static boolean isPrime(int number) {

        if (number <= 1) {
            return false;
        }
        boolean isPrime = true;
        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }

    //3. Java program to find Fibonacci series upto a  given number range
    public static void findFibonacciSeries(int n) {
        int first = 0, second = 1, next;
        for (int i = 0; i <= n; i++) {
            System.out.print(first + " ");
            next = first + second;
            first = second;
            second = next;
        }

    }
    public static void reverseANumber(int num){
        if(num<10){
            System.out.println(num);
            return;
        }

        int remainder = 0;
        StringBuilder rev= new StringBuilder();
//        num=123;
        while (num!=0){
            remainder = num%10; //3
            num = num/10;// 12
            rev.append(remainder);
        }
        System.out.println();
        System.out.println(rev.toString());
    }
    public static void isArmStrongOrNot(int num){
        System.out.println("Arm Strong");
        if(num<10){
            System.out.println(num);
            return;
        }
        // First count the length of numbers
        int temp = num;
        int counter=0;
        while (temp!=0){
            temp = temp/10;
            counter++;
        }

        System.out.println(counter);
        int finalValue = 0;
        while (num!=0){
            int rem =num%10;
            num=num/10;
            int each = 0;
            for (int i = 0; i < counter; i++) {
                if(each==0){
                    each = rem;
                    continue;
                }
                each = each*rem;
            }
            finalValue+=each;
        }
        System.out.println(finalValue);
    }

    public static void isPalindrome(int num){
        int temp = num;
        String rev = "";
        while (num!=0){
            int rem = num*10;
        }
    }

//    1. Java program to reverse a string
    public static void reverseAString(String str){
        String rev="";
        for (int i = str.length()-1; i >=0; i--) {
            rev+=str.charAt(i);
        }

        System.out.println(rev);
    }
    public static void findDuplicatesCharsInAString(String str){
        Map<Character, Integer> map=new HashMap<>();
        char[] charArray = str.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            map.computeIfPresent(charArray[i],(character, integer) -> integer+1);
            map.computeIfAbsent(charArray[i],character -> 1);
//            if(map.containsKey(charArray[i])){
//                map.computeIfPresent(charArray[i],(character, integer) -> integer+1);
//            }else{
//                map.computeIfAbsent(charArray[i],character -> 1);
//            }
        }

        map.forEach((character, integer) -> {
            if(integer>1)
            {
                System.out.print(character);
            }
        });

//        System.out.println(map);
    }

}
