package com.oceanleo.project.ssm.support.orm.datasource;

import org.springframework.util.StringUtils;

/**
 * @author haiyang.li on 2017/9/28.
 */
public class DataSourceContextHolder {

    public static final String DATA_SOURCE_SSM = "ssmDataSource";
    public static final String DATA_SOURCE_SSM2 = "ssm2DataSource";
    public static final String DATA_SOURCE_TRADING = "tradingDataSource";

    private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();

    public static void setDataSourceType(String dataSourceType) {
        contextHolder.set(dataSourceType);
    }

    public static String getDataType() {
        String dataSource = contextHolder.get();
        if (StringUtils.isEmpty(dataSource)) {
            return DATA_SOURCE_SSM;
        } else {
            return dataSource;
        }
    }

    public static void clearDataSourceType() {
        contextHolder.remove();
    }
}
