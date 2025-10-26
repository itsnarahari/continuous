package com.codility.configuration;

import com.codility.beans.LegacyPaymentsService;
import com.codility.beans.MaintenanceConfig;
import com.codility.beans.UsersRepository;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("com.codility.utils")
@PropertySource("classpath:prodcution.properties")
@Import(MaintenanceConfig.class)
public class SystemConfig {

    @Bean(initMethod = "initialize")
    public UsersRepository usersRepository(){
        return new UsersRepository();
    }

    @Bean("paymentService")
    public LegacyPaymentsService legacyPaymentService(){
        return new LegacyPaymentsService();
    }

}
