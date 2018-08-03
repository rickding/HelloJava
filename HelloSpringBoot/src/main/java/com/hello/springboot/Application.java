package com.hello.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hello.mapper")
public class Application {
    /**
     * https://blog.csdn.net/winter_chen001/article/details/77249029
     * https://blog.csdn.net/Winter_chen001/article/details/80010967
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
