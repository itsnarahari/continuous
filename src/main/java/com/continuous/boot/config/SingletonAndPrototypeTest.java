package com.continuous.boot.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SingletonAndPrototypeTest {

    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext();

        SingletonBean firstSingleton = context.getBean(SingletonBean.class);
        PrototypeBean firstPrototype = firstSingleton.getPrototypeBean();

        // get singleton bean instance one more time
        SingletonBean secondSingleton = context.getBean(SingletonBean.class);
        PrototypeBean secondPrototype = secondSingleton.getPrototypeBean();

        System.out.println(firstPrototype==secondPrototype);

    }
}
