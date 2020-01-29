package com.hello.quartz;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("quartz")
public class QuartzConfig {
    private String cron;
    private String[] urlArr;

    @Bean
    public JobDetail quartzJob() {
        JobDataMap dataMap = new JobDataMap() {{
            put("job_str", "str_test");
            put("url_arr", urlArr);
        }};

        return JobBuilder.newJob(QuartzJob.class)
                .usingJobData(dataMap)
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger quartzTrigger() {
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cron);
        JobDataMap dataMap = new JobDataMap() {{
            put("trigger_int", 333);
        }};

        return TriggerBuilder.newTrigger()
                .forJob(quartzJob())
                .withSchedule(scheduleBuilder)
                .usingJobData(dataMap)
                .build();
    }

    public String getCron() {
        return cron;
    }

    public void setCron(String cron) {
        this.cron = cron;
    }

    public String[] getUrlArr() {
        return urlArr;
    }

    public void setUrlArr(String[] urlArr) {
        this.urlArr = urlArr;
    }
}
