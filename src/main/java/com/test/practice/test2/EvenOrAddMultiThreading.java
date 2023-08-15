package com.test.practice.test2;

public class EvenOrAddMultiThreading {

    int val = 1;

    public synchronized void printEvenNumber() {
        val++;
        System.out.print(val);
    }

    public synchronized void oddEvenNumber() {
        val++;
        System.out.print(val);
    }

    public static void main(String[] args) {
        EvenOrAddMultiThreading evenOrAddMultiThreading = new EvenOrAddMultiThreading();
        for (int i = 1; i < 10; i++) {
            Thread t1 = new Thread(new Runnable() {
                public void run() {
                    evenOrAddMultiThreading.printEvenNumber();
                }
            });
            Thread t2 = new Thread(new Runnable() {
                public void run() {
                    evenOrAddMultiThreading.oddEvenNumber();
                }
            });

            t1.start();
            t2.start();
        }
    }
}
