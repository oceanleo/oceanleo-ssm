package com.oceanleo.project.ssm.service.impl;

import com.oceanleo.project.ssm.dao.OracleDao;
import com.oceanleo.project.ssm.service.OracleService;

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
