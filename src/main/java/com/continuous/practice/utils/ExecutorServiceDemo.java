package com.continuous.practice.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceDemo {

    public static void main(String[] args) {

        System.out.println("Main Thread " + Thread.currentThread().getName());

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        System.out.println("Active Count " + Runtime.getRuntime().availableProcessors());
        Runnable runnable = () -> {
            for (int i = 0; i < 100; i++) {
                System.out.println(i);
            }
            System.out.println("Inside : " + Thread.currentThread().getName());
        };
        Runnable runnable2 = () -> {
            System.out.println("Inside : " + Thread.currentThread().getName());
        };
        Runnable runnabl3 = () -> {
            System.out.println("Inside : " + Thread.currentThread().getName());
        };

        executorService.submit(runnable);
        executorService.submit(runnable2);
        executorService.submit(runnabl3);
        executorService.shutdown();
    }
}
