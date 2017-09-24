package com.ocean.project.ssm.support.mvc.interceptor;

import com.ocean.project.ssm.support.core.exception.BizException;
import com.ocean.project.ssm.support.mvc.domain.Result;
import com.ocean.project.ssm.support.mvc.domain.ResultCode;
import com.ocean.project.ssm.support.orm.page.PageList;
import com.ocean.project.ssm.support.utils.DateUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

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
        try {
            Object obj = point.proceed();
            if (obj instanceof PageList) {
                System.out.println(DateUtils.formatCurrentTime()+" 返回数据到前端 实现分页接口 封装分页对象 ");
                PageList pageList = (PageList) obj;
                Map<String, Object> resultMap = new HashMap<String, Object>();
                resultMap.put("total", pageList.getTotal());
                resultMap.put("list", pageList);
                return new Result(resultMap);
            }
            System.out.println(DateUtils.formatCurrentTime()+" 返回数据到前端 正常返回数据");
            return new Result(obj);
        } catch (BizException e) {
            return new Result(false, ResultCode.BUSINESS_FAIL, e.getMessage());
        } catch (Throwable e) {
            return new Result(false, ResultCode.SYSTEM_FAIL, SYSTEM_EXCEPTION_MESSAGE);
        }
    }
}
