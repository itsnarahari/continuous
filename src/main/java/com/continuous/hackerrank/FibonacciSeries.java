package com.continuous.hackerrank;

public class FibonacciSeries {
    public static void fibo(int size) {
        // 10
        // 0 1 1 2 3 5 8 13 21
        int n1 = 0, n2 = 1, n3;
        System.out.print(n1 + " " + n2);
        for (int i = 2; i < size; i++) {
            n3 = n1 + n2;
            System.out.print(n3 + " ");
            n1 = n2;
            n2 = n3;
        }
    }

    public static void main(String[] args) {
        fibo(10);
    }
}
