package com.lhy.ssm.support.task;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author haiyang.li 2017/7/27.
 */
public class DomainTask {

    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public void taskTest(){
        System.out.println("定时调度启动:当前时间---"+simpleDateFormat.format(new Date()));
    }
}
