package com.oceanleo.project.ssm.support.orm.datasource;

/**
 * 数据库连接基础信息
 *
 * @author haiyang.li on 2017/9/28.
 */
public class DataSourceBaseMataData {

    private String dataSourceName = "mysql";

    private DataSourceBaseMataData(){}

    public String getDataSourceName() {
        return dataSourceName;
    }

    public void setDataSourceName(String dataSourceName) {
        this.dataSourceName = dataSourceName;
    }
}
