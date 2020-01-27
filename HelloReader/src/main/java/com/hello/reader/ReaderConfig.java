package com.hello.reader;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("reader")
public class ReaderConfig {
    private String cron;
    private String[] urlList;

    @Bean
    public JobDetail readerJob() {
        return JobBuilder.newJob(ReaderJob.class).storeDurably().build();
    }

    @Bean
    public Trigger readerTrigger() {
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cron);

        return TriggerBuilder.newTrigger()
                .forJob(readerJob())
                .withSchedule(scheduleBuilder)
                .build();
    }

    public String getCron() {
        return cron;
    }

    public void setCron(String cron) {
        this.cron = cron;
    }

    public String[] getUrlList() {
        return urlList;
    }

    public void setUrlList(String[] urlList) {
        this.urlList = urlList;
    }
}
