package com.test.practice.multiThreading;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer> {
    int i;
    public MyCallable(int i) {
        this.i=i;
    }

    @Override
    public Integer call() throws Exception {
        return i;
    }

}