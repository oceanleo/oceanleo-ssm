package com.oceanleo.project.ssm.support.log;

import com.alibaba.fastjson.JSONObject;
import com.oceanleo.project.ssm.domain.Log;
import com.oceanleo.project.ssm.service.LogService;
import com.oceanleo.project.ssm.service.impl.LogServiceImpl;
import com.oceanleo.project.ssm.support.orm.query.PageQuery;
import com.oceanleo.project.ssm.support.utils.DateUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.lang.reflect.Method;
import java.util.List;

/**
 * 业务日志记录
 *
 * @author haiyang.li on 2017/9/30.
 */
@Component
public class AppBizLogSupport {

    @Resource
    private LogService logService;

    public void createAppLog(ProceedingJoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        //获取目标方法
        Method targetMethod = methodSignature.getMethod();
        //获取目标类
        Class targetClass = methodSignature.getDeclaringType();
        //类上面是否有日志注解
        System.out.println(DateUtils.formatCurrentTime() + " Aop Service 执行结束,判断是否要记录日志");
        if (!LogServiceImpl.class.equals(targetClass)) {
            //判断类上是否有 AppLog 注解
            if (targetClass.isAnnotationPresent(AppLog.class)) {
                System.out.println(DateUtils.formatCurrentTime() + " 访问 " + targetClass.getSimpleName() + " 业务层,有 AppLog 注解,记录日志");
                //方法上面是否有 AppLog 注解
                if (targetMethod.isAnnotationPresent(AppLog.class)) {
                    System.out.println(DateUtils.formatCurrentTime() + " 访问 " + joinPoint.getSignature().toString() + " 方法,方法有 AppLog 注解,记录日志");
                    Log log = new Log();
                    AppLog modelLog = (AppLog) targetClass.getAnnotation(AppLog.class);
                    log.setModel(modelLog.value());
                    AppLog methodLog = targetMethod.getAnnotation(AppLog.class);
                    log.setMethodName(methodLog.value());
                    Object[] params = joinPoint.getArgs();
                    if (params != null && params.length > 0) {
                        log.setArguments(JSONObject.toJSONString(params));
                    }
                    log.setSuccess(true);
                    logService.create(log);
                    System.out.println(DateUtils.formatCurrentTime() + " 日志记录成功");
                } else {
                    System.out.println(DateUtils.formatCurrentTime() + " 访问 " + joinPoint.getSignature().toString() + " 方法,方法没有 AppLog 注解,不记录日志");
                }
            } else {
                System.out.println(DateUtils.formatCurrentTime() + " 访问 " + joinPoint.getSignature().toString() + " 业务层,类上没有AppLog注解,不记录日志");
            }
        } else {
            System.out.println(DateUtils.formatCurrentTime() + " 访问 LogService 业务层,不记录日志");
        }
    }

    public List<Log> findAppLog(){
        return logService.findAll(new PageQuery());
    }
}