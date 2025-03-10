package com.continuous.practice.latest;

import java.util.concurrent.*;

public class FutureExampl {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(new Task());

        System.out.println("completed");
        executorService.shutdownNow();
        System.out.println(executorService.isTerminated());
    }
}

class Task implements Callable {

    @Override
    public Object call() throws Exception {
        System.out.println("Stopping");
        Thread.sleep(5000);
        System.out.println("resumed");
        return null;
    }
}
