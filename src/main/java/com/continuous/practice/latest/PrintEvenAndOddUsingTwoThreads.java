package com.continuous.practice.latest;

public class PrintEvenAndOddUsingTwoThreads {

    public static volatile int counter = 1;

    public static synchronized void printOdd() {

        if (counter % 2 != 0) {
            System.out.print(counter + " ");
        }
        counter++;

    }

    public static synchronized void printEven() {

        if (counter % 2 == 0) {
            System.out.print(counter + " ");
        }
        counter++;

    }

    public static void main(String[] args) {

        for (int i = 1; i < 10; i++) {
            new Thread(() -> {
                printOdd();
            }).start();
            new Thread(() -> {
                printEven();
            }).start();
        }

    }
}

