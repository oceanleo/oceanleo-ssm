package com.ocean.project.ssm.support.orm.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 多数据源
 *
 * @author haiyang.li on 2017/9/22.
 */
public class MultipleDataSource extends AbstractRoutingDataSource {

    private static final ThreadLocal<String> DATA_SOURCE_KEY = new InheritableThreadLocal<String>();

    public static void setDataSourceKey(String dataSource) {
        DATA_SOURCE_KEY.set(dataSource);
    }

    @Override
    protected Object determineCurrentLookupKey() {
        return DATA_SOURCE_KEY.get();
    }
}
