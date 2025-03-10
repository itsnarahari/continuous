package com.continuous.boot.config;

import com.continuous.boot.models.Notification;
import org.springframework.context.annotation.Bean;

public class NotificationConfiguration {

    @Bean(name = "mobileNotification")
    public Notification mobileNotification() {
        return new Notification("mobileNotification");
    }

    @Bean(name = "desktopNotification")
    public Notification desktopNotification() {
        return new Notification("desktopNotification");
    }

    @Bean(name = "iosNotification")
    public Notification iosNotification() {
        return new Notification("iosNotification");
    }
}
