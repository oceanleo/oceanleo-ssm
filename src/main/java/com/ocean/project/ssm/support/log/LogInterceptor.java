package com.ocean.project.ssm.support.log;

import com.ocean.project.ssm.dao.LogDao;
import com.ocean.project.ssm.support.utils.DateUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.SourceLocation;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 日志拦截器
 *
 * @author haiyang.li on 2017/8/30.
 */
@Component
@Aspect
public class LogInterceptor {

    @Resource
    private LogDao logDao;

    @Around("execution(public * com.ocean..service.*Service.*(..))")
    public Object createLog(ProceedingJoinPoint joinPoint) throws Throwable {
        Object object;
        try {
            System.out.println(DateUtils.formatCurrentTime()+" 访问Service方法,方法名： "+joinPoint.getSignature().toString());
            System.out.println(DateUtils.formatCurrentTime()+" 日志 Aop Service方法执行前");
            object = joinPoint.proceed();
            System.out.println(DateUtils.formatCurrentTime()+" 日志 Aop Service方法执行后");
        } finally {

        }
        return object;
    }
}
