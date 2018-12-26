package com.hello.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;

//@SpringBootApplication
//public class WebApplication {
//    public static void main(String[] args) {
//        SpringApplication.run(WebApplication.class, args);
//    }
//}

@EnableAutoConfiguration
@Configuration
@ComponentScan
public class WebApplication extends SpringBootServletInitializer implements WebApplicationInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(WebApplication.class).showBanner(false);
    }

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }
}
