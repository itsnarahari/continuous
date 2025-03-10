package com.continuous.practice.test2;

public class MultiThreadingPrintEvenAndOddNumbers {

    int size = 10;
    int counter = 0;
    boolean isOdd = false;

    public void printEven() throws InterruptedException {
        synchronized (this) {
            while (counter >= size) {
                while (isOdd == false) {
                    wait();
                }
                System.out.println("Even number " + counter);
                counter++;
                isOdd = true;
                notify();
            }
        }
    }

    public void printOdd() throws InterruptedException {
        synchronized (this) {
            while (isOdd == true) {
                wait();
            }
            System.out.println("Odd number " + counter);
            counter++;
            isOdd = false;
            notify();
        }
    }

    public static void main(String[] args) {

        MultiThreadingPrintEvenAndOddNumbers multiThreadingPrintEvenAndOddNumbers = new MultiThreadingPrintEvenAndOddNumbers();
        new Thread(() -> {
            try {
                multiThreadingPrintEvenAndOddNumbers.printEven();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }).start();
        new Thread(() -> {
            try {
                multiThreadingPrintEvenAndOddNumbers.printOdd();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }).start();
    }
}
