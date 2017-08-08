package com.lhy.ssm.support.dataSources;

import org.springframework.beans.factory.FactoryBean;

import javax.sql.DataSource;

/**
 * @author haiyang.li on 2017/8/8.
 */
public class DataSourcesFactory implements FactoryBean<DataSource> {

    private DataSource dataSource;




    @Override
    public DataSource getObject() throws Exception {
        return dataSource;
    }

    @Override
    public Class<?> getObjectType() {
        return DataSource.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
