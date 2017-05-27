package com.hello.quartz.jobs;

import com.hello.quartz.util.AnotherBean;
import com.hello.quartz.util.DateUtil;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * Created by user on 2017/5/26.
 */
public class FirstScheduledJob extends QuartzJobBean {

    private AnotherBean anotherBean;

    @Override
    protected void executeInternal(JobExecutionContext arg0)
            throws JobExecutionException {
        System.out.println(DateUtil.getHHmmSS() + " I am FirstScheduledJob");

        if (null != anotherBean) {
            anotherBean.printAnotherMessage();
        }
    }

    public void setAnotherBean(AnotherBean anotherBean) {
        this.anotherBean = anotherBean;
    }
}