package com.continuous.practice.multiThreading;

public class MultiThreading {

    public static void main(String[] args) {
        Thread m = Thread.currentThread();
        System.out.println(m.getId());
        Thread t1 = new Thread();
        t1.start();
        System.out.println(t1.getId());
        Thread t2 = new Thread();
        t1 = t2;
        t1.start();
        System.out.println(t1.getId());
    }
}
