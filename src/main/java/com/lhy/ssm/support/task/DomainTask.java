package com.lhy.ssm.support.task;

/**
 * @author haiyang.li 2017/7/27.
 */
public class DomainTask {

    private int a = 0;

    public void taskTest(){
        a++;
        System.out.println("DomainTask:-------"+a);
    }
}
