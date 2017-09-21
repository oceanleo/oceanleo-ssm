package com.ocean.project.ssm.support.orm.datasource;

import org.apache.commons.dbcp.BasicDataSource;

import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

/**
 * 数据库连接
 *
 * @author haiyang.li on 2017/9/21.
 */
public class DataSource extends BasicDataSource {

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }
}
