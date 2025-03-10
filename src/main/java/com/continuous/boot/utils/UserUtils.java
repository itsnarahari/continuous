package com.continuous.boot.utils;

import com.continuous.boot.models.Customer;

import java.util.List;
import java.util.stream.Collectors;

public class UserUtils {

    public static String isSuccess(String email) {
        return "success";
    }

    public static void get(List<Customer> customers) {
        String collect = customers.stream().filter(customer -> customer.getName() != null).map(customer -> customer.getName()).collect(Collectors.joining());
        if (collect.isEmpty()) {
            throw new RuntimeException("Its empty");
        }

    }

}
