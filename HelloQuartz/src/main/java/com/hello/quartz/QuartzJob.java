package com.hello.quartz;

import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Date;
import java.util.Map;

public class QuartzJob extends QuartzJobBean {
    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        // System.out.printf("quartz cron: %s\n", new Date());

        // get data from context
        JobDataMap dataMap = context.getMergedJobDataMap();
        for (Map.Entry<String, Object> data : dataMap.entrySet()) {
            // System.out.printf("%s = %s\n", data.getKey(), data.getValue());
        }

        // do work
    }
}
