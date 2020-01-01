package com.hello.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@Async
public class HelloSchedule {
    @Async
    @Scheduled(cron = "0/5 * * * * *")
    public void scheduled1() {
        System.out.println(String.format("cron %d", System.currentTimeMillis()));
    }

    @Scheduled(fixedRate = 1000 * 7)
    public void scheduled2() {
        System.out.println(String.format("fixedRate %d", System.currentTimeMillis()));
    }

    @Scheduled(fixedDelay = 1000 * 11)
    public void scheduled3() {
        System.out.println(String.format("fixedDelay %d", System.currentTimeMillis()));
    }
}
