package com.hello.quartz.jobs;

import com.hello.quartz.util.DateUtil;
import org.springframework.stereotype.Component;

/**
 * Created by user on 2017/5/26.
 */

@Component("myBean")
public class MyBean {

    public void printMessage() {
        System.out.println(DateUtil.getHHmmSS() + " I am MyBean. I am called by MethodInvokingJobDetailFactoryBean using SimpleTriggerFactoryBean");
    }

}