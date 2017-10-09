package com.ocean.project.ssm.service.impl;

import com.ocean.project.ssm.dao.OracleDao;
import com.ocean.project.ssm.service.OracleService;
import com.ocean.project.ssm.support.orm.datasource.DataSourceContextHolder;

import javax.annotation.Resource;

/**
 * @author haiyang.li on 2017/9/29.
 */
public class OracleServiceImpl implements OracleService {

    @Resource
    private OracleDao oracleDao;

    @Override
    public String testConnect() {
        return oracleDao.test();
    }
}
