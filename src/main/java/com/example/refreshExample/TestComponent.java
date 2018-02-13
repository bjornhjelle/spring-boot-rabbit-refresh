package com.example.refreshExample;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by Bjørn Hjelle, Acando on 12.02.2018.
 */
@Component
@RefreshScope
public class TestComponent {

    @Value("${bar:World!}")
    String bar;

    public String get() {
        return bar;
    }


    @PostConstruct
    public void init() {
       System.out.println(this.hashCode() + " TestComponent, value is: " + bar);
    }


}
