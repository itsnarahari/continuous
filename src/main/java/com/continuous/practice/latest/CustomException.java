package com.continuous.practice.latest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class CustomRuntimeException extends RuntimeException {
    CustomRuntimeException(String message) {
        super(message);
    }
}

public class CustomException extends Exception {
    CustomException(String message) {
        super(message);
    }
}

class MyEx {

    public void m1() {
        throw new CustomRuntimeException("ds");
    }

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.submit(()->{
            System.out.println();
        });
        throw new CustomRuntimeException("ddsd");

    }
}
