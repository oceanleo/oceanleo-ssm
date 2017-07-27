package com.lhy.ssm.support;

import com.lhy.ssm.enumeration.ResultCode;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * 对控制层返回的json数据统一封装
 *
 * @author haiyang.li 2017/7/17.
 */
@Component
@Aspect
public class ControllerResultSupport {

    @Around("execution(public * com.lhy.ssm.controller.*Controller.*(..)) && @annotation(org.springframework.web.bind.annotation.ResponseBody) && !execution(public * com.lhy.ssm.controller.ServicesController.*(..))")
    public Object setResult(ProceedingJoinPoint point){
        Result result;
        Object obj;
        try{
            obj = point.proceed();
            result = new Result(obj);
        }catch (BizException e){
            result = new Result(false,ResultCode.BUSINESS_FAIL,e.getMessage());
        }catch (Throwable e){
            result = new Result(false,ResultCode.SYSTEM_FAIL,"服务器异常，请重试！");
        }
        return result;
    }
}
