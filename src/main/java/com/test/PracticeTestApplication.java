package com.test;

import com.test.boot.config.SingletonBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

//interface MyService{
//    public void doMyWork();
//}
//@Service
//@Qualifier("MyServiceImpl1")
//class MyServiceImpl1 implements MyService{
//    @Override
//    public void doMyWork() {
//        System.out.println("MyServiceImpl1");
//    }
//}
//@Service
//@Qualifier("MyServiceImpl2")
//class MyServiceImpl2 implements MyService{
//    @Override
//    public void doMyWork() {
//        System.out.println("MyServiceImpl2");
//    }
//}
@SpringBootApplication
@EnableAsync
@EnableScheduling
public class PracticeTestApplication {

//    @Qualifier("MyServiceImpl2")
//    @Autowired
//    MyService myService;

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
