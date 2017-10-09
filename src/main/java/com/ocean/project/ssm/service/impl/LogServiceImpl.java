package com.ocean.project.ssm.service.impl;

import com.ocean.project.ssm.dao.LogDao;
import com.ocean.project.ssm.domain.Log;
import com.ocean.project.ssm.service.LogService;

import javax.annotation.Resource;

/**
 * @author haiyang.li on 2017/9/30.
 */
public class LogServiceImpl implements LogService {
    
    @Resource
    private LogDao logDao;
    
    @Override
    public void create(Log log) {
        logDao.insert(log);
    }
}
