package com.continuous.boot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;


@Configuration
public class CommonConfiguration {


    @Value("${babu}")
    String babu;
}
