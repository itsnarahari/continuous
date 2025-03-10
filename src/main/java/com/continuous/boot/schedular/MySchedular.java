package com.continuous.boot.schedular;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Component
public class MySchedular {

    @Scheduled(cron = "0 * * * * *")
    public void run1() {

        System.out.println("Hello Fixed Rate -------------> Time now is : "
                + LocalTime.now().format(DateTimeFormatter.ofPattern("hh mm ss")));

    }
}
