package com.ocean.project.ssm.support.log;

import com.alibaba.fastjson.JSONObject;
import com.ocean.project.ssm.domain.Log;
import com.ocean.project.ssm.service.impl.LogServiceImpl;
import com.ocean.project.ssm.support.utils.DateUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.lang.reflect.Method;

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

//    @Around("execution(public * com.ocean..service.*Service.*(..))")
//    public Object createLog(ProceedingJoinPoint joinPoint) throws Throwable {
//        Signature signature = joinPoint.getSignature();
//        MethodSignature methodSignature = (MethodSignature) signature;
//        //获取目标方法
//        Method targetMethod = methodSignature.getMethod();
//        //获取目标类
//        Class targetClass = methodSignature.getDeclaringType();
//        //类上面是否有日志注解
//        System.out.println(DateUtils.formatCurrentTime() + " aop日志,访问Service方法,方法名： " + joinPoint.getSignature().toString());
//        System.out.println(DateUtils.formatCurrentTime() + " 日志 Aop Service方法执行前");
//        Object object = joinPoint.proceed();
//        if (!LogServiceImpl.class.equals(targetClass)) {
//            boolean flag = false;
//            Log log = new Log();
//            //判断方法上面是否有日志注解
//            if (targetMethod.isAnnotationPresent(AppLog.class)) {
//                flag = true;
//                AppLog methodLog = targetMethod.getAnnotation(AppLog.class);
//                String method = methodLog.value();
//                log.setMethodName(method);
//                //判断类上是否有日志注解
//                if (targetClass.isAnnotationPresent(AppLog.class)) {
//                    AppLog modelLog = (AppLog) targetClass.getAnnotation(AppLog.class);
//                    String model = modelLog.value();
//                    log.setModel(model);
//                }
//                Object[] params = joinPoint.getArgs();
//                if(params != null && params.length>0){
//                    log.setArguments(JSONObject.toJSONString(params));
//                }
//                log.setSuccess(true);
//            }
//            if (flag) {
//                appBizLogSupport.createAppLog(log);
//            }
//        }
//        System.out.println(DateUtils.formatCurrentTime() + " 日志 Aop Service方法执行后,记录日志");
//        return object;
//    }
}
