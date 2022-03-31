package com.test.boot.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
class MobileNotification implements OTPSender{
    @Override
    public void sender() {
        System.out.println("MobileNotification");
    }
}

class EmailNotification implements OTPSender{
    @Override
    public void sender() {
        System.out.println("EmailNotification");
    }
}
