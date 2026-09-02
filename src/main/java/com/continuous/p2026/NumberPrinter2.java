package com.continuous.p2026;

public class NumberPrinter2 {

    private int number = 1;
    private final int max = 20;

    public synchronized void print(int threadId) {

        while (number <= max) {

            while ((number - 1) % 3 != threadId && number <= max) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }

            if (number <= max) {
                System.out.println(
                        Thread.currentThread().getName() + " : " + number
                );
                number++;
                notify();
            }
        }
    }

    public static void main(String[] args) {

        NumberPrinter2 printer = new NumberPrinter2();

        Thread t1 = new Thread(() -> printer.print(0), "Thread-1");
        Thread t2 = new Thread(() -> printer.print(1), "Thread-2");
        Thread t3 = new Thread(() -> printer.print(2), "Thread-3");

        t1.start();
        t2.start();
        t3.start();
    }
}