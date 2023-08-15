package com.test.practice.multiThreading;

import lombok.SneakyThrows;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class ExecutorServiceExample {

    static ExecutorService executor = Executors.newFixedThreadPool(5);

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            executor.submit(new ExampleRunner(i));
        }
        boolean b = executor.awaitTermination(2, TimeUnit.SECONDS);
        System.out.println(b);
//        executor.shutdownNow();
//        System.out.println("Shut down completed");
//        executor.submit(new ExampleRunner(3));
    }
}

class ExampleRunner implements Runnable {
    int i;

    public ExampleRunner(int i) {
        this.i = i;
    }

    @SneakyThrows
    @Override
    public void run() {
        Thread.sleep(4000);
        System.out.println("I Value " + i + " " + Thread.currentThread().getName());
    }
}
