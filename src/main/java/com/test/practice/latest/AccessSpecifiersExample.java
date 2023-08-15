package com.test.practice.latest;

import org.springframework.web.client.RestTemplate;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class AccessSpecifiersExample {

    static ExecutorService executor = (ThreadPoolExecutor) Executors.newSingleThreadExecutor();


    private String str = "34";
    static Integer sta = 434;
    public Integer p = 434;
    public static String s = "sdfs";

    public static void abc() {
        s = "fsd";
        String str = "df";
        str = "er";
    }

    public static void main(String[] args) {
        Integer sta = 534;
        String str = "main";
        Integer p = 3;
        System.out.println(sta);
        System.out.println(str);
        System.out.println(p);
    }
}
