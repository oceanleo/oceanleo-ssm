package com.ocean.project.ssm.support.orm.datasource;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 多数据源
 *
 * @author haiyang.li on 2017/9/22.
 */
public class DynamicRoutingDataSource extends AbstractRoutingDataSource implements InitializingBean {

    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceContextHolder.getDataType();
    }

    @Override
    public void afterPropertiesSet() {
        super.afterPropertiesSet();
    }
}
