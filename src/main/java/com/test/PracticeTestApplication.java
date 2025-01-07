package com.test;

import com.test.boot.config.SingletonBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableAsync
@EnableScheduling
public class PracticeTestApplication {

    @Autowired
    SingletonBean singletonBean;

    @Bean
    RestTemplate restTemplate() {
        singletonBean.getPrototypeBean();
        return new RestTemplate();
    }
    public static void main(String[] args) {
        SpringApplication.run(PracticeTestApplication.class, args);
    }
}
