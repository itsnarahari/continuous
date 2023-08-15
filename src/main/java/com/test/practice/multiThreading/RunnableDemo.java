package com.test.practice.multiThreading;

class A implements Runnable {
    @Override
    public void run() {
        System.out.println("Inside of RUN" + Thread.currentThread());
    }
}

public class RunnableDemo {
    public static void main(String[] args) {
        Thread thread = new Thread(new A());
        thread.start();
    }
}

