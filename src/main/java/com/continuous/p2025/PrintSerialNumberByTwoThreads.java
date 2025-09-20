package com.continuous.p2025;

import com.continuous.practice.latest.PrintEvenAndOddUsingTwoThreads;

public class PrintSerialNumberByTwoThreads {

    private final Object lock = new Object();
    private int counter=1;
    private final int limit =10;
    public static void main(String[] args) {

        PrintSerialNumberByTwoThreads printEvenAndOddUsingTwoThreads = new PrintSerialNumberByTwoThreads();
        Thread oddThread = new Thread(()->printEvenAndOddUsingTwoThreads.printOdd(), "Odd");
        Thread evenThread = new Thread(()->printEvenAndOddUsingTwoThreads.printEven(), "Even");

        oddThread.start();
        evenThread.start();
    }

    public void printOdd(){
        synchronized (lock){
            while (counter<=limit){
                if(counter %2 ==1){
                    System.out.println(Thread.currentThread().getName()+" "+counter);
                    counter++;
                    lock.notify();
                }else{
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

    public void printEven(){
        synchronized (lock){
            while (counter<=limit){
                if(counter%2==0){
                    System.out.println(Thread.currentThread().getName()+" "+counter);
                    counter++;
                    lock.notify();
                }else{
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
}
