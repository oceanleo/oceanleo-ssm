package com.oceanleo.project.ssm.support.log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 日志拦截器
 *
 * @author haiyang.li on 2017/8/30.
 */
@Aspect
@Order(1)
@Component
public class LogInterceptor {

    @Resource
    private AppBizLogSupport appBizLogSupport;

    @Pointcut("execution(public * com.oceanleo..service.*Service.*(..))")
    public void execute() {

    }

    @Around("execute()")
    public Object createLog(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            return joinPoint.proceed();
        } finally {
            //service 执行完成后,记录日志,避免多数据源事物的交叉
            appBizLogSupport.createAppLog(joinPoint);
        }
    }
}
