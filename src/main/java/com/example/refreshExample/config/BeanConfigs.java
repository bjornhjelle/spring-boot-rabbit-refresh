package com.example.refreshExample.config;

import com.example.refreshExample.AmqpConsumer;

import com.example.refreshExample.TestComponent;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Bjørn Hjelle, Acando on 12.02.2018.
 */
@Configuration
@RefreshScope
public class BeanConfigs {

    @Bean
    @RefreshScope
    public AmqpConsumer ampqConsumer(TestComponent testComponent) {
        return new AmqpConsumer(testComponent);
    }

}
