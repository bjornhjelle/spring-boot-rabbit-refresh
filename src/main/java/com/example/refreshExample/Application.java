package com.example.refreshExample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by Bjørn Hjelle, Acando on 12.02.2018.
 */
@SpringBootApplication
public class Application {

    @Autowired
    TestComponent testComponent;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}