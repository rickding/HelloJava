package com.hello.runner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RunnerApplication {
    public static void main(String[] args) {
        System.out.println("Spring application start ...");
        SpringApplication.run(RunnerApplication.class, args);
        System.out.println("Spring application end ...");
    }
}
