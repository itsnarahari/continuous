package com.test.practice.test2;

public class RevereseANumber {

    public static int reverseANumber(int num){
        int reversed=0;
        while (num!=0){
            int digit = num%10;
            reversed = reversed*10+digit;
            num/=10;
        }
        return  reversed;
    }
    public static void main(String[] args) {
        System.out.println(reverseANumber(89645));
    }
}
