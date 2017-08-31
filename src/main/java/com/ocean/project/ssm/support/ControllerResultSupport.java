package com.ocean.project.ssm.support;

import com.ocean.project.ssm.enumeration.ResultCode;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 对控制层返回的json数据统一封装
 *
 * @author haiyang.li 2017/7/17.
 */
@Component
@Aspect
public class ControllerResultSupport {

    private Logger logger = LoggerFactory.getLogger(ControllerResultSupport.class);

    private static final String SYSTEM_EXCEPTION_MESSAGE = "服务器异常，请重试！";

    @Around("execution(public * com.ocean.project.ssm.controller.*Controller.*(..)) " +
            "&& @annotation(org.springframework.web.bind.annotation.ResponseBody) " +
            "&& !@annotation(com.ocean.project.ssm.support.annotation.NotUseResult) " +
            "&& !execution(public * com.ocean.project.ssm.controller.ServicesController.*(..))")
    public Object setResult(ProceedingJoinPoint point) {
        Result result;
        Object obj;
        try {
            obj = point.proceed();
            result = new Result(obj);
        } catch (BizException e) {
            logger.error("控制层返回错误",e);
            result = new Result(false, ResultCode.BUSINESS_FAIL, e.getMessage());
        } catch (Throwable e) {
            logger.error("控制层返回错误",e);
            result = new Result(false, ResultCode.SYSTEM_FAIL, SYSTEM_EXCEPTION_MESSAGE);
        }
        return result;
    }
}
