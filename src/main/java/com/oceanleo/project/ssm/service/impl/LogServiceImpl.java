package com.oceanleo.project.ssm.service.impl;

import com.oceanleo.project.ssm.dao.LogDao;
import com.oceanleo.project.ssm.domain.Log;
import com.oceanleo.project.ssm.service.LogService;
import com.oceanleo.project.ssm.support.orm.query.PageQuery;

import javax.annotation.Resource;
import java.util.List;

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

    @Override
    public List<Log> findAll(PageQuery query) {
        return logDao.selectAll(query);
    }

    @Override
    public void createList(List<Log> logList) {
        logDao.insertList(logList);
    }
}
