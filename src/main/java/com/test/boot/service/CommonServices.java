package com.test.boot.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class CommonServices {


    @Async("taskExecutor")
    public String process(){
        try {
            System.out.println("process");
            asyncM1();
            asyncM2();
            asyncM3();
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    @Async("taskExecutor")
    public String asyncM1(){
        try {
            System.out.println("asyncM1");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Async("taskExecutor")
    public String asyncM2(){
        try {
            System.out.println("asyncM2");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Async("taskExecutor")
    public String asyncM3(){
        try {
            System.out.println("asyncM3");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
