package com.ocean.project.ssm.support.orm.interceptor;

import com.ocean.project.ssm.support.orm.datasource.DataSourceContextHolder;
import com.ocean.project.ssm.support.orm.page.MybatisPagination;
import com.ocean.project.ssm.support.orm.query.Pageable;
import com.ocean.project.ssm.support.utils.BeanUtils;
import com.ocean.project.ssm.support.utils.DateUtils;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.Date;
import java.util.List;
import java.util.Properties;

/**
 * sql 拦截器
 *
 * @author haiyang.li on 2017/9/21.
 */
@Intercepts({
        @Signature(method = "prepare", type = StatementHandler.class, args = {Connection.class}),
        @Signature(type = ResultSetHandler.class, method = "handleResultSets", args = {Statement.class})})
public class PageInterceptor implements Interceptor {

    private static Logger logger = LoggerFactory.getLogger(PageInterceptor.class);
    //sql构造器 默认mysql
    private static SqlBuilder sqlBuilder = new MySqlBuilder();
    //
    private static SqlBuilder mysqlBuilder = new MySqlBuilder();
    //
    private static SqlBuilder oracleBuilder = new OracleSqlBuilder();

    private static void initSqlBuilder(Connection connection) {
        //todo 查询拦截 判断是mysql 还是oracle
        try {
            if (connection != null) {
                String driverName = connection.getMetaData().getDriverName().toLowerCase();
//                String driverName = DataSourceContextHolder.getDataType();
                System.out.println(DateUtils.formatCurrentTime() + " 数据库连接驱动,driverName: " + driverName);
                if (driverName.contains("mysql")) {
                    System.out.println(DateUtils.formatCurrentTime() + " 设置mysql分页构造器");
                    if(!(sqlBuilder instanceof MySqlBuilder)){
                        sqlBuilder = mysqlBuilder;
                    }
                } else if (driverName.contains("oracle")) {
                    System.out.println(DateUtils.formatCurrentTime() + " oracle分页构造器");
                    if(!(sqlBuilder instanceof OracleSqlBuilder)){
                       sqlBuilder = oracleBuilder;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(DateUtils.formatCurrentTime() + " 分页拦截器获取连接信息失败 " + e.getMessage());
        }
    }

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        System.out.println(DateUtils.format(new Date()) + " thread name:" + Thread.currentThread().getName());
        //发sql 和 返回结果都会进行拦截
        Object target = invocation.getTarget();
        if ((target instanceof ResultSetHandler)) {
            System.out.println(DateUtils.format(new Date()) + " sql查询后,返回数据拦截");
            return processAsPagingListIfNecessary(invocation);
        }
        System.out.println(DateUtils.format(new Date()) + " sql查询前,查询sql拦截");
        RoutingStatementHandler handler = (RoutingStatementHandler) invocation.getTarget();
        Connection connection = (Connection) invocation.getArgs()[0];
        //区分数据库连接
        initSqlBuilder(connection);
        StatementHandler delegate = (StatementHandler) BeanUtils.getFieldValue(handler, "delegate");
        BoundSql boundSql = delegate.getBoundSql();
        System.out.println(DateUtils.format(new Date()) + " 原始sql : \r\n\t" + boundSql.getSql());
        Object paramObject = boundSql.getParameterObject();
        //只要实现了接口则认为必然分页
        if (paramObject instanceof Pageable) {
            System.out.println(DateUtils.format(new Date()) + " 实现了分页接口,进行分页");
            System.out.println(DateUtils.format(new Date()) + " 分页参数: pageNumber:" + ((Pageable) paramObject).getPageNumber() + ",pageSize:" + ((Pageable) paramObject).getPageSize());

            MybatisPagination mybatisPagination = new MybatisPagination((Pageable) paramObject);
            MappedStatement mappedStatement = (MappedStatement) BeanUtils.getFieldValue(delegate, "mappedStatement");
            boundSql = mappedStatement.getBoundSql(mybatisPagination.getParams());
            countTotalRecord(connection, mappedStatement, mybatisPagination, boundSql);

            String pageSql = getPageSql(mybatisPagination, boundSql.getSql());
            System.out.println(DateUtils.format(new Date()) + " 分页之后的sql : \r\n\t" + pageSql);

            BeanUtils.setFieldValue(boundSql, "sql", pageSql);
            BeanUtils.setFieldValue(delegate, "boundSql", boundSql);
            BeanUtils.setFieldValue(delegate.getParameterHandler(), "boundSql", boundSql);
        } else {
            System.out.println(DateUtils.format(new Date()) + " 没有实现了分页接口,不进行分页");
        }
        return invocation.proceed();
    }

    private Object processAsPagingListIfNecessary(Invocation invocation) throws InvocationTargetException, IllegalAccessException {
        Object result = invocation.proceed();
        System.out.println(DateUtils.format(new Date()) + " 返回数据类型 " + result.getClass());
        if ((MybatisPagination.isPagingResult()) && ((result instanceof List))) {
            System.out.println(DateUtils.format(new Date()) + " 返回数据支持分页 返回数据类型为 List " + result.getClass());
            return MybatisPagination.toPageList((List) result);
        }
        System.out.println(DateUtils.format(new Date()) + " 返回数据不进行分页处理");
        return result;
    }

    private String getPageSql(MybatisPagination page, String sql) {
        if (sqlBuilder == null) {
            return "";
        }
        return sqlBuilder.querySql(page, sql);
    }

    private void countTotalRecord(Connection connection, MappedStatement mappedStatement, MybatisPagination mybatisPagination, BoundSql boundSql) {
        String countSql = sqlBuilder.countSql(mybatisPagination, boundSql.getSql());
        List<ParameterMapping> parameterMappings = boundSql.getParameterMappings();

        Object additionalParameters = BeanUtils.getFieldValue(boundSql, "additionalParameters");
        Object metaParameters = BeanUtils.getFieldValue(boundSql, "metaParameters");

        BoundSql sql = new BoundSql(mappedStatement.getConfiguration(), countSql, parameterMappings, mybatisPagination.getParams());

        BeanUtils.setFieldValue(sql, "additionalParameters", additionalParameters);
        BeanUtils.setFieldValue(sql, "metaParameters", metaParameters);

        ParameterHandler parameterHandler = new DefaultParameterHandler(mappedStatement, mybatisPagination.getParams(), sql);
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            System.out.println(DateUtils.format(new Date()) + " 查询总条数SQL: \r\n\t" + sql.getSql());
            preparedStatement = connection.prepareStatement(sql.getSql());
            parameterHandler.setParameters(preparedStatement);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int anInt = resultSet.getInt(1);
                System.out.println(DateUtils.format(new Date()) + " 返回总条数:" + anInt);
                MybatisPagination.setTotal(anInt);
            }
        } catch (SQLException e) {
            if (logger.isErrorEnabled()) {
                logger.error(e.getMessage(), e);
            }
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null)
                    preparedStatement.close();
            } catch (SQLException e) {
                logger.error(e.getMessage(), e);
            }
        }
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {

    }

    /**
     * SQL封装接口
     */
    interface SqlBuilder {
        //查询分页sql
        String querySql(MybatisPagination myBatisPageNation, String sql);

        //查询总条数sql
        String countSql(MybatisPagination myBatisPageNation, String sql);
    }

    private static class MySqlBuilder implements SqlBuilder {

        @Override
        public String querySql(MybatisPagination page, String sql) {
            return sql + " limit " + page.getStartNum() + "," + page.getPageSize();
        }

        @Override
        public String countSql(MybatisPagination page, String sql) {
            String lowerCaseSql = sql.toLowerCase();
            boolean containsGroup = lowerCaseSql.contains("group by");
            boolean containsDistinct = lowerCaseSql.contains("distinct ");
            if (containsGroup || containsDistinct) {
                return "select count(1) from (" + sql + ") t";
            }
            int index = lowerCaseSql.indexOf("from");
            return "select count(1) " + sql.substring(index);
        }
    }

    private static class OracleSqlBuilder implements SqlBuilder {

        @Override
        public String querySql(MybatisPagination page, String sql) {
            return "select * from ( select tmp_page.*, rownum row_id from ( " + sql + " ) tmp_page where rownum <= " + page.getEndNum() + " ) where row_id > " + page.getStartNum();
        }

        @Override
        public String countSql(MybatisPagination page, String sql) {
            return "select count(*) from (" + sql + ") tmp_count";
        }
    }
}
