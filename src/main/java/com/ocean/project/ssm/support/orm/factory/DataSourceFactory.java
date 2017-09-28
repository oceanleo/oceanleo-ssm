package com.ocean.project.ssm.support.orm.factory;

import com.ocean.project.ssm.support.utils.DateUtils;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.StringUtils;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Map;
import java.util.Properties;

/**
 * 数据连接工厂
 *
 * @author haiyang.li on 2017/9/28.
 */
public class DataSourceFactory implements FactoryBean<DataSource>, InitializingBean {
    //数据源
    private DataSource dataSource;
    //jndi 数据源名称
    private String jndi;
    //tomcat jndi 前缀
    private static final String TOMCAT_JNDI_PREFIX = "comp/env/";
    //数据源配置
    private Properties param;
    //默认数据源配置
    private static Properties DEFAULT_PROPERTIES = new Properties();

    static {
        DEFAULT_PROPERTIES.put("initialSize", "0");
        DEFAULT_PROPERTIES.put("maxActive", "20");
        DEFAULT_PROPERTIES.put("minIdle", "0");
        DEFAULT_PROPERTIES.put("maxWait", "60000");
        DEFAULT_PROPERTIES.put("poolPreparedStatements", "true");
        DEFAULT_PROPERTIES.put("maxPoolPreparedStatementPerConnectionSize", "33");
        DEFAULT_PROPERTIES.put("validationQuery", "select 1 from dual");
        DEFAULT_PROPERTIES.put("testOnBorrow", "false");
        DEFAULT_PROPERTIES.put("testOnReturn", "false");
        DEFAULT_PROPERTIES.put("testWhileIdle", "60000");
        //配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒
        DEFAULT_PROPERTIES.put("timeBetweenEvictionRunsMillis", "20");
        // 配置一个连接在池中最小生存的时间，单位是毫秒
        DEFAULT_PROPERTIES.put("minEvictableIdleTimeMillis", "25200000");
        DEFAULT_PROPERTIES.put("removeAbandoned", "true");
        DEFAULT_PROPERTIES.put("removeAbandonedTimeout", "1800");
        DEFAULT_PROPERTIES.put("logAbandoned", "true");
        DEFAULT_PROPERTIES.put("filters", "mergeStat");
    }

    private void mergeProperties() {
        for (Map.Entry<Object, Object> entry : DEFAULT_PROPERTIES.entrySet()) {
            //判断是否已经存在属性
            if (!param.containsKey(entry.getKey())) {
                param.put(entry.getKey(), entry.getValue());
            }
        }
    }

    private void bindDataSourceMetaData() {

    }

    private DataSource getDatasourceByJndi(Context context) {
        DataSource dataSource = null;
        try {
            String defaultJndi = jndi;
            // todo 判断服务器是否tomcat
            if (isTomcat()) {
                defaultJndi = "java:/" + TOMCAT_JNDI_PREFIX + defaultJndi;
            }
            System.out.println(DateUtils.formatCurrentTime() + " Jndi 数据源路径: " + defaultJndi);
            dataSource = (DataSource) context.lookup(defaultJndi);
            System.out.println(DateUtils.formatCurrentTime()+" 获取数据库驱动: "+dataSource.getConnection().getMetaData().getDriverName());
        } catch (SQLException e){
            System.out.println(DateUtils.formatCurrentTime() + " 获取数据库连接失败: "+e.getMessage());
        } catch (NamingException e) {
            System.out.println(DateUtils.formatCurrentTime() + " 获取Jndi数据源失败: "+e.getMessage());
        }
        System.out.println(DateUtils.formatCurrentTime()+" 获取Jndi数据源成功,Jndi 名称: " +jndi);
        return dataSource;
    }

    private Boolean isTomcat() {
        return true;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if (StringUtils.hasText(jndi)) {
            System.out.println(DateUtils.formatCurrentTime() + " 使用Jndi数据源,Jndi名称: " + jndi);
            Context context = new InitialContext();
            dataSource = getDatasourceByJndi(context);
        } else {
//            System.out.println(DateUtils.formatCurrentTime() + " 没有jndi数据源名称,使用默认");
//            //数据库连接设置属性
//            mergeProperties();
//            dataSource = DruidDataSourceFactory.createDataSource(param);
//            ((DruidDataSource) dataSource).init();
        }
        //绑定数据库连接信息
        bindDataSourceMetaData();
    }

    @Override
    public DataSource getObject() throws Exception {
        return dataSource;
    }

    @Override
    public Class<?> getObjectType() {
        return BasicDataSource.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    public void setJndi(String jndi) {
        this.jndi = jndi;
    }

    public void setParam(Properties param) {
        this.param = param;
    }
}
