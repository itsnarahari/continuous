package com.continuous.p2025;

public class April2025Test {

    public static void main(String[] args) {
//        1. Java program to Find Odd or Even number
        findOddOrEvenNumber(11);
        findPrimeOrNotNumber(0);

    }

//    1. Java program to Find Odd or Even number
    public static void findOddOrEvenNumber(int number){
        if(number%2==0){
            System.out.println("This %d is Even number".formatted(number));
        }else{
            System.out.println("This %d is Odd number".formatted(number));
        }
    }

//    2. Java program to find Prime number
public static void findPrimeOrNotNumber(int number){

    double n = Math.sqrt(number);
    System.out.println(n);
    System.out.println(number/2);
    System.out.println(number%2);
    boolean isPrime = isPrime(number);

    if(isPrime){
        System.out.println("This %d is prime number".formatted(number));
    }else{
        System.out.println("This %d is not a prime number".formatted(number));
    }
}

public static boolean isPrime(int number){

        if(number<=1){
            return false;
        }
    boolean isPrime=true;
    for (int i = 2; i <= number/2; i++) {
        if(number%i==0){
            isPrime=false;
            break;
        }
    }
    return isPrime;
}

//3. Java program to find Fibonacci series upto a  given number range
    

}
