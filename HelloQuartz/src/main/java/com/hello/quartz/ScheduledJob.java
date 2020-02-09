package com.hello.quartz;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Async
public class ScheduledJob {
    @Async
    @Scheduled(cron = "0/19 * * * * ?")
    public void scheduledCron() {
        System.out.printf("scheduled cron: %s\n", new Date());
    }

    @Scheduled(fixedRate = 1000 * 29, initialDelay = 1000 * 30)
    public void scheduledRate() {
        System.out.printf("fixedRate: %s\n", new Date());
    }

    @Scheduled(fixedDelay = 1000 * 37, initialDelay = 1000 * 40)
    public void scheduledDelay() {
        System.out.printf("fixedDelay: %s\n", new Date());
    }
}
