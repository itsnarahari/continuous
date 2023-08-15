package com.test.practice.latest;

import com.test.practice.EmployeeDatasource;

import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class CompletableFutureExample {

    public void sendNotifications() {

        CompletableFuture.supplyAsync(() -> {
            System.out.println("Get Employees" + Thread.currentThread().getName());
            return EmployeeDatasource.getEmployees();
        }).thenApplyAsync(employees -> {
            System.out.println("Filter by email time" + Thread.currentThread().getName());
            return employees.stream().filter(employee -> employee.getModeOfContact().equalsIgnoreCase("email"))
                    .collect(Collectors.toList());
        }).thenApplyAsync(employees -> {
            System.out.println("Get Male Employees" + Thread.currentThread().getName());
            return employees.stream().filter(employee -> employee.getGender().equalsIgnoreCase("Male"))
                    .collect(Collectors.toList());
        }).thenAcceptAsync(employees -> employees.forEach(employee -> {
            System.out.println("Email Sender " + Thread.currentThread().getName());
            emailSender(employee.getEmail());
        }));

    }

    public static void emailSender(String email) {
        System.out.println("Sending " + email);
    }

    public static void main(String[] args) {

        CompletableFutureExample completableFutureExample = new CompletableFutureExample();
        completableFutureExample.sendNotifications();

    }
}
