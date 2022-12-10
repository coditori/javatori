package com.massoudafrashteh.code;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = "com.massoudafrashteh.code")
@EnableTransactionManagement
public class Main {

    public static void main(final String[] args) {
        SpringApplication.run(Main.class, args);
    }
}