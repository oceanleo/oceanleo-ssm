package com.ocean.project.ssm.support.mybatis;

import com.ocean.project.ssm.support.utils.DateUtils;
import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.plugin.*;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Date;
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
        //发sql 和 返回结果都会进行拦截
        Object obj = invocation.getTarget();
        System.out.println(DateUtils.format(new Date())+" 分页拦截器执行");
        System.out.println("当前线程名称 : "+Thread.currentThread());
        //区分是 查询拦截 还是 返回拦截
        if(obj instanceof ResultSetHandler){
            //todo 返回拦截 返回数据处理
            System.out.println(DateUtils.format(new Date())+" 返回数据拦截 class name : "+obj.getClass().getName());
        }else{
            RoutingStatementHandler handler = (RoutingStatementHandler) invocation.getTarget();
            Connection connection = (Connection) invocation.getArgs()[0];
//            StatementHandler delegate = (StatementHandler) BeanUtils.getFieldValue(handler, "delegate");
//            BoundSql boundSql = delegate.getBoundSql();
//            Object paramObject = boundSql.getParameterObject();
            System.out.println(DateUtils.format(new Date())+" 查询语句拦截 class name : "+obj.getClass().getName());
            //todo 查询拦截 判断是mysql 还是oracle
        }
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
