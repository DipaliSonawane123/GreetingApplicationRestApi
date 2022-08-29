package com.example.greetingproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class GreetingProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(GreetingProjectApplication.class, args);
    }

}
