package com.hello.quartz;

import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Map;
import java.util.Random;

public class QuartzJob extends QuartzJobBean {
    private static Random random = new Random();
    private static int URL_INDEX = -1;

    @Autowired
    Reader reader;

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        // get data from context
        JobDataMap dataMap = context.getMergedJobDataMap();
        for (Map.Entry<String, Object> data : dataMap.entrySet()) {
            System.out.printf("%s = %s\n", data.getKey(), data.getValue());
        }

        // do work
        String[] urlArr = (String[]) dataMap.get("url_arr");
        int count = Math.max(1, random.nextInt(urlArr.length));

        for (int i = 0; i < count; i++) {
            URL_INDEX = (URL_INDEX + 1) % urlArr.length;
            String ret = reader.read(urlArr[URL_INDEX]);
            System.out.printf("read: %s\n", ret == null || ret.length() < 50 ? ret : ret.substring(0, 50));
        }
    }
}
