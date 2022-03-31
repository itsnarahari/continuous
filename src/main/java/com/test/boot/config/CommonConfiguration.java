package com.test.boot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;

@Configuration
public class CommonConfiguration {


    @Value("${babu}")
    String babu;

    @PostConstruct
    public void init(){
        System.out.println("ffs");
        System.out.println(babu);
    }

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public void m1(){
        System.out.println("Singleton scope");
    }
    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public void m2(){
        System.out.println("proto type");
    }
}
