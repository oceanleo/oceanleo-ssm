package com.oceanleo.project.ssm.support.orm.interceptor;

import com.oceanleo.project.ssm.support.orm.datasource.DataSourceContextHolder;
import com.oceanleo.project.ssm.support.utils.DateUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author haiyang.li on 2017/9/30.
 */
@Aspect
@Order(0)
@Component
public class DataSourceAspect {

    @Pointcut("execution(public * com.oceanleo..service.*Service.*(..))")
    public void execute(){

    }

    @Before("execute()")
    public void setDataSource(JoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        System.out.println(DateUtils.formatCurrentTime() + " 访问service层开始,访问类名:" + className);
        if (className.contains("Oracle")) {
            System.out.println(DateUtils.formatCurrentTime() + " 设置数据源:" + DataSourceContextHolder.DATA_SOURCE_TRADING);
            DataSourceContextHolder.setDataSourceType(DataSourceContextHolder.DATA_SOURCE_TRADING);
        } else if(className.contains("Log")){
            System.out.println(DateUtils.formatCurrentTime() + " 设置数据源:" + DataSourceContextHolder.DATA_SOURCE_SSM);
            DataSourceContextHolder.setDataSourceType(DataSourceContextHolder.DATA_SOURCE_SSM);
        } else {
            System.out.println(DateUtils.formatCurrentTime() + " 设置数据源:" + DataSourceContextHolder.DATA_SOURCE_SSM);
            DataSourceContextHolder.setDataSourceType(DataSourceContextHolder.DATA_SOURCE_SSM);
        }
    }

    @After("execute()")
    public void setClearDataSource(JoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        System.out.println(DateUtils.formatCurrentTime() + " 访问service层结束,访问类名:" + className+",清空数据源");
        DataSourceContextHolder.clearDataSourceType();
    }
}
