package com.continuous.boot.config;

import com.continuous.boot.models.Address;
import com.continuous.boot.models.Employee;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@EnableAsync
public class AsyncConfig {

    @Bean("employee")
    @Scope(scopeName = "singleton")
    public Employee employee() {
        return new Employee();
    }

    @Bean("prototype")
    @Scope(scopeName = "singleton")
    public Address address() {
        return new Address();
    }

    @Bean(name = "taskExecutor")
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(4);
        executor.setMaxPoolSize(4);
        executor.setQueueCapacity(1000);
        executor.setThreadNamePrefix("userThread-");
        executor.initialize();
        return executor;
    }
}