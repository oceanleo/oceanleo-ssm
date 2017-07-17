package com.lhy.ssm.support;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @author haiyang.li 2017/7/17.
 */
public class ControllerResultSupport {

    public Object setResult(ProceedingJoinPoint point) throws Throwable{
        System.out.println("ControllerResultSupport==========");
        return point.proceed();
    }
}
