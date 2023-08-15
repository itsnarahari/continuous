package com.test.practice.utils;

import java.util.Arrays;
import java.util.concurrent.*;

public class ExecutorServiceExceptionHandler {

    public static void main(String[] args) throws InterruptedException {
        // Create a fixed thread pool executor
        ExecutorService threadPool = new MyThreadPoolExecutor(Runtime.getRuntime().availableProcessors(), 10, 0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>());
        Object obj = null;
        for (int i = 1; i <= 100; i++) {
            obj = i;
//            if(i==5){
//                obj="MyString";
//            }
            threadPool.execute(new MyTask(obj));
        }

        System.out.println(threadPool.isTerminated());

//        threadPool.shutdown();
    }
}

class MyThreadPoolExecutor extends ThreadPoolExecutor {
    public MyThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime,
                                TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    @Override
    public void afterExecute(Runnable r, Throwable t) {
        super.afterExecute(r, t);
        // If submit() method is called instead of execute()
        if (t == null && r instanceof Future<?>) {
            try {
                Object result = ((Future<?>) r).get();
            } catch (CancellationException e) {
                t = e;
            } catch (ExecutionException e) {
                t = e.getCause();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        if (t != null) {
            // Exception occurred
            System.err.println("Uncaught exception is detected! " + t
                    + " st: " + Arrays.toString(t.getStackTrace()));
            // ... Handle the exception
            // Restart the runnable again
            execute(r);
        }
        // ... Perform cleanup actions
    }
}

final class MyTask implements Runnable {

    private Object o;

    public MyTask(Object obj) {
        this.o = obj;
    }

    @Override
    public void run() {
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        Integer integer = Integer.valueOf(String.valueOf(o));
        System.out.println(integer);
    }
}
