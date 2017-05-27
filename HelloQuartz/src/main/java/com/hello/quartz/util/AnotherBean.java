package com.hello.quartz.util;

import org.springframework.stereotype.Component;

/**
 * Created by user on 2017/5/26.
 */

@Component("anotherBean")
public class AnotherBean {

    public void printAnotherMessage() {
        System.out.println(DateUtil.getHHmmSS() + " I am AnotherBean. I am called by Quartz jobBean using CronTriggerFactoryBean");
    }

}