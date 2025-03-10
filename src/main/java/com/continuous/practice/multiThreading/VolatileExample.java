package com.continuous.practice.multiThreading;

public class VolatileExample {
    private static boolean flag = true;

    public static void main(String[] args) {
        new Printer().start();
//        new Changer().start();
    }

    static class Printer extends Thread {
        @Override
        public void run() {
            System.out.println(flag);
            while (flag) {
                System.out.println(Thread.currentThread().getName());
            }
        }
    }

    static class Changer extends Thread {
        @Override
        public void run() {
            flag = false;
        }
    }
}
