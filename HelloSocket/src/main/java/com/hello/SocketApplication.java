package com.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAutoConfiguration
@SpringBootApplication
public class SocketApplication {
    public static void main(String[] args) {
        SpringApplication.run(SocketApplication.class, args);
    }
}
