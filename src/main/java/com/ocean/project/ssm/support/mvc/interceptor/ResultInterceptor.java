package com.ocean.project.ssm.support.mvc.interceptor;

import com.ocean.project.ssm.support.core.BizException;
import com.ocean.project.ssm.support.mvc.domain.Result;
import com.ocean.project.ssm.support.mvc.domain.ResultCode;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * 控制层返回数据封装
 *
 * @author haiyang.li on 2017/9/21.
 */
@Component
@Aspect
public class ResultInterceptor {

    private static final String SYSTEM_EXCEPTION_MESSAGE = "服务器异常，请重试！";

    @Around("execution(public * com.ocean..*.controller.*Controller.*(..)) " +
            "&& @annotation(org.springframework.web.bind.annotation.ResponseBody) " +
            "&& !@annotation(com.ocean.project.ssm.support.mvc.annotation.NotUseResult) ")
    public Object setResult(ProceedingJoinPoint point) {
        Result result;
        Object obj;
        try {
            obj = point.proceed();
            result = new Result(obj);
        } catch (BizException e) {
            result = new Result(false, ResultCode.BUSINESS_FAIL, e.getMessage());
        } catch (Throwable e) {
            result = new Result(false, ResultCode.SYSTEM_FAIL, SYSTEM_EXCEPTION_MESSAGE);
        }
        return result;
    }
}
