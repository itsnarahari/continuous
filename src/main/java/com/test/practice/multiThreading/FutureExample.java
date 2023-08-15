package com.test.practice.multiThreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class FutureExample {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        System.out.println("process " + Runtime.getRuntime().availableProcessors());
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        List<Callable<Integer>> callables = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            callables.add(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    System.out.println(finalI);
                    return finalI;
                }
            });
        }

//        executorService.invokeAll(callables);
        List<Future<Integer>> futures = executorService.invokeAll(callables);

//        for (Future f:futures) {
//            System.out.println(f.get());
//        }

//        futures.stream().forEach(integerFuture -> {
//            try {
//                System.out.println(integerFuture.get());
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            } catch (ExecutionException e) {
//                e.printStackTrace();
//            }
//        });
        executorService.shutdown();
    }
}
