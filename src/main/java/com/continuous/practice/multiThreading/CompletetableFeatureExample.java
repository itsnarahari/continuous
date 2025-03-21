package com.continuous.practice.multiThreading;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.CompletableFuture;

public class CompletetableFeatureExample {

    public static String getOrder() {
        System.out.println("Acquiring Order");
        System.out.println(Thread.currentThread().getName());
        return "ORDER-1234";
    }

    public static Map<String, Object> performPayment(String orderId) {
        System.out.println("Payment Done....");
        Map<String, Object> map = new HashMap<>();
        map.put("orderId", orderId);
        map.put("paymentId", new Random().nextInt(568975));
        System.out.println(Thread.currentThread().getName());
        return map;
    }

    public static Map<String, Object> dispatchOrder(Map<String, Object> map) {
        System.out.println(String.format("Order Dispatched for order id %s and Payment was done %s", map.get("orderId"), map.get("paymentId")));
        System.out.println(Thread.currentThread().getName());
        return map;
    }

    public static String sendNotification(Map<String, Object> map) {
        System.out.println("Notification has been sent for order id " + map.get("orderId"));
        System.out.println(Thread.currentThread().getName());
        return "sent";
    }

    public static void main(String[] args) {
        CompletableFuture.supplyAsync(() -> getOrder())
                .thenApplyAsync(order -> performPayment(order))
                .thenApply(order -> dispatchOrder(order))
                .thenApply(order -> sendNotification(order));
    }
}
