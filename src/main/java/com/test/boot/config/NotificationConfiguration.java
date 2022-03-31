package com.test.boot.config;

import com.test.boot.models.Notification;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class NotificationConfiguration {

    @Bean(name = "mobileNotification")
    public Notification mobileNotification(){
        return new Notification("mobileNotification");
    }
    @Bean(name = "desktopNotification")
    public Notification desktopNotification(){
        return new Notification("desktopNotification");
    }
    @Bean(name = "iosNotification")
    public Notification iosNotification(){
        return new Notification("iosNotification");
    }
}
