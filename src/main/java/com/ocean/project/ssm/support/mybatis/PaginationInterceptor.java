package com.ocean.project.ssm.support.mybatis;

import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.*;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author haiyang.li on 2017/8/8.
 */
@Intercepts({
        @Signature(method = "prepare", type = StatementHandler.class, args = {Connection.class}),
        @Signature(type = ResultSetHandler.class, method = "handleResultSets", args = {Statement.class})})
public class PaginationInterceptor implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Object obj = invocation.getTarget();
        // todo 分页拦截器
        System.out.println("分页拦截器执行:"+obj.getClass().getName());
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
