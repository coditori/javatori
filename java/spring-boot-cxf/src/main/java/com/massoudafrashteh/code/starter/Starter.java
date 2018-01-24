package com.massoudafrashteh.code.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class Starter {

    public static void main(final String[] args) {
        SpringApplication.run(CxfConfig.class, args);
    }
}