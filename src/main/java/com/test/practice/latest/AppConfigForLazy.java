package com.test.practice.latest;

import com.test.boot.models.Customer;
import com.test.practice.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Lazy
@Configuration
public class AppConfigForLazy {
    @Bean
    public Company companyBean() {
        return new Company();
    }

    @Bean
    public Employee employeeBean() {
        return new Employee();
    }

    @Bean
    public Customer customerBean() {
        return new Customer();
    }

    public static void main(String[] args) {
        ApplicationContext ctxt = new AnnotationConfigApplicationContext(AppConfigForLazy.class);
//        Customer customer = ctxt.getBean(Customer.class);
    }
}

