package com.continuous.practice.multiThreading;

public class Thread2 {

    private static volatile boolean flag = true;

    public static void main(String[] args) {

        new Runnable() {
            @Override
            public void run() {
                m1(flag);
            }
        }.run();

        new Runnable() {
            @Override
            public void run() {
                m1(flag);
            }
        }.run();
    }

    public static void m1(boolean flag) {
        while (Thread2.flag) {
            System.out.println(Thread.currentThread().getName());
        }
    }

    public static void set() {
        flag = false;
    }
}

