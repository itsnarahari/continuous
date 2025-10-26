package com.codility.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MaintenanceConfig {
    @Bean
    public String maintenanceMessage(){
        String msg = "MaintenanceConfig Bean Loaded!";
        System.out.println("["+msg+"]");
        return msg;
    }
}
