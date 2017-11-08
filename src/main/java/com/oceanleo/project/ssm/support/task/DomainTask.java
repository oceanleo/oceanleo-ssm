package com.oceanleo.project.ssm.support.task;

import com.oceanleo.project.ssm.support.utils.DateUtils;

import java.util.Date;

/**
 * @author haiyang.li 2017/7/27.
 */
public class DomainTask {

    public void taskTest() {
        System.out.println(DateUtils.format(new Date()) + " 定时调度启动:当前时间---");
    }
}
