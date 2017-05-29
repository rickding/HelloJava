package com.hello.order.job;

/**
 * @author lohocc
 * @Date 2016年8月5日下午2:20:08
 */
public abstract class AbstractJob {

    private static final String RUN_FLAG = "1";

    public abstract String getJobName();

    public abstract String getJobGroup();

    public abstract void handle(/*JobConfigVO configVO*/);

    /**
     * Quartz 定时任务
     */
    public void taskStart() {
        if (RUN_FLAG.equals("1"))
            handle(/*configVO*/);
    }
}
