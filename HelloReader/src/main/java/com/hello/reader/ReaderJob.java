package com.hello.reader;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Random;

public class ReaderJob extends QuartzJobBean {
    private static Random random = new Random();
    private static int URL_INDEX = -1;

    @Autowired
    ReaderConfig readerConfig;

    @Autowired
    Reader reader;

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        String[] urlArr = readerConfig.getUrlList();
        int count = Math.max(1, random.nextInt(urlArr.length));

        for (int i = 0; i < count; i++) {
            URL_INDEX = (URL_INDEX + 1) % urlArr.length;
            String ret = reader.read(urlArr[URL_INDEX]);
            System.out.printf("read: %s\n", ret == null || ret.length() < 50 ? ret : ret.substring(0, 50));
        }
    }
}
