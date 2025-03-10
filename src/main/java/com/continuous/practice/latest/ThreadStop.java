package com.continuous.practice.latest;

public class ThreadStop {
    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.exit();
    }
}

class MyThread implements Runnable {
    private volatile boolean flag = false;

    @Override
    public void run() {
        while (!flag) {
            System.out.println("MyThread is running");
        }
        System.out.println("The My Thread is stopped");
    }

    public void exit() {
        flag = true;
    }
}
